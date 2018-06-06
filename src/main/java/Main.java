import com.zhenhui.demo.rxjava.theroy.Observable;
import com.zhenhui.demo.rxjava.theroy.OnSubscribe;
import com.zhenhui.demo.rxjava.theroy.Subscriber;

public class Main {

    public static void main(String[] args) {

        Observable.create(new OnSubscribe<String>() {
            public void call(Subscriber<? super String> subscriber) {
                for (int i = 0; i < 10; ++i) {
                    subscriber.onNext("string " + i);
                }
            }
        }).subscribe(new Subscriber<String>() {
            public void onNext(String var) {
                System.out.println(var);
            }

            public void onComplete() {

            }

            public void onError(Throwable t) {

            }
        });

    }

}
