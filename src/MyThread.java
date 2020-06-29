public class MyThread extends Thread {
    static char curLet = 'A';
    static Object mon = new Object();

    @Override
    public void run() {
    }

    public void printLetter(char c , char nextLet) {
        System.out.println("Запущен поток печати буквы " + curLet);
        synchronized (mon) {
            for (int i = 0; i < 5; i++) {
                try {
                    while (curLet != c) {
                        System.out.println("Вызван метод wait  в потоке " + curLet);
                        mon.wait();
                    }
                    System.out.println(c);
                    curLet = nextLet;
                    mon.notifyAll();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
