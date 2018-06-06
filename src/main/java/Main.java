import com.zhenhui.demo.rxjava.theroy.Observable;
import com.zhenhui.demo.rxjava.theroy.OnSubscribe;
import com.zhenhui.demo.rxjava.theroy.Subscriber;
import com.zhenhui.demo.rxjava.theroy.schedule.Schedulers;

public class Main {

    public static void main(String[] args) {

        Observable.create(new OnSubscribe<Integer>() {
            public void call(Subscriber<? super Integer> subscriber) {
                for (int i = 0; i < 10; ++i) {

                    System.out.println("OnSubscribe,current thread : " + Thread.currentThread().getName());

                    subscriber.onNext(i);
                }
            }
        }).map(e -> "map+" + e)
            .subscribeOn(Schedulers.io())
            .observeOn(Schedulers.mainThread())
            .subscribe(new Subscriber<String>() {
            public void onNext(String var) {

                System.out.println("Subscriber,current thread : " + Thread.currentThread().getName());
                System.out.println(var);
            }

            public void onComplete() {

            }

            public void onError(Throwable t) {

            }
        });


        // 模拟消息队列(主线程)
        try {
            Schedulers.runLoop();
        } catch (InterruptedException e) {
            // ignore
        }

    }

}
