package JavaCore.LabmdHome.Task2;


public class Main {
    public static void main(String[] args) {

        OnTaskDoneListener listener = System.out::println;
        OnTaskErrorListener erListener = System.out::println;

        Worker worker = new Worker(listener, erListener);
        worker.start();
    }
}

class Worker {

    private OnTaskDoneListener callback;
    private OnTaskErrorListener erCallback;

    public Worker(OnTaskDoneListener callback, OnTaskErrorListener erCallback) {
        this.callback = callback;
        this.erCallback = erCallback;

    }

    public void start() {
        for (int i = 0; i < 100; i++) {
            if (i == 33) {
                erCallback.onError("Task " + i + " *** ERROR ***");
            }
            callback.onDone("Task " + (i + 1) + " is done");
        }
    }

}

@FunctionalInterface
interface OnTaskDoneListener {
    void onDone(String result);
}

@FunctionalInterface
interface OnTaskErrorListener {
    void onError(String result);
}



