package ht.thread;

import android.util.Log;

import com.bumptech.glide.disklrucache.DiskLruCache;

import org.opencv.core.Mat;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

import ht.activity.LocationActivity;
import ht.bean.Coordinate;

/**
 * Created by dn on 2018/6/17.
 */

public class ImageThread {
    private final static String TAG = "ImageThread";

    private ExecutorService mExecutorService;
    private FutureTask<Integer> mFutureTask;
    private List<Integer> mLedLineList = new ArrayList<>();

    public ImageThread(){
        mExecutorService = Executors.newCachedThreadPool(new DaemonThreadFactory());
    }

    public void handlePic(){
        mExecutorService.execute(new Runnable() {
            @Override
            public void run() {
                if (handlePicture != null) {
                    handlePicture.handle();
                }
            }
        });
    }

    public List<Integer> getLedLineCount(List<Mat> imgs){
        mLedLineList.clear();
        final CountDownLatch countDownLatch = new CountDownLatch(3);
        for (final Mat img:imgs){
            Callable<Integer> callable = new Callable<Integer>() {
                @Override
                public Integer call() throws Exception {
                        return handlePicture.getCount(img);
                }
            };

            mFutureTask = new FutureTask<Integer>(callable){
                @Override
                protected void done() {
                    try{
                        Log.e(TAG, "mLedLineList: "+ mFutureTask.get());
                        mLedLineList.add(mFutureTask.get());
                        countDownLatch.countDown();
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }catch (ExecutionException e){
                        e.printStackTrace();
                    }
                }
            };

            //启动任务
            mExecutorService.execute(mFutureTask);
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            return mLedLineList;
        }

    }

    public void isCollinear(final List<Coordinate> X, final List<Coordinate> Y) {
        mExecutorService.execute(new Runnable() {
            @Override
            public void run() {
                if (handlePicture != null) {
                    handlePicture.isCollinear(X, Y);
                    getLocation();
                }
            }
        });
    }

    public void getLocation() {
        mExecutorService.execute(new Runnable() {
            @Override
            public void run() {
                if (handlePicture != null) {
                    handlePicture.getLocation();
                }
            }
        });
    }

    public interface HandlerPicture {
        void handle();
        int getCount(Mat img);
        void isCollinear(List<Coordinate> X, List<Coordinate> Y);
        void getLocation();
    }

    HandlerPicture handlePicture;

    public void setHandlePictureListener(HandlerPicture handlePicture) {
        this.handlePicture = handlePicture;
    }

}
