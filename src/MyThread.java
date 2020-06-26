public class MyThread extends Thread {
    static char letter = 'a';
    static Object mon = new Object();

    public MyThread(String name) {
        System.out.println("Поток с именем " + name);
        start();
    }

    @Override
    public void run() {
        printLetterA();
        printLetterB();
        printLetterC();
    }

    public void printLetterA() {
        System.out.println("Запущен поток печати буквы а");
        synchronized (mon) {
            for (int i = 0; i < 5; i++) {
                while (letter != 'a') {
                    try {
                        System.out.println("Вызван метод wait  в потоке а");
                        mon.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                    System.out.println(letter);
                    letter = 'b';
                    mon.notifyAll();
            }
            System.out.println("+");
        }
    }

    public void printLetterB() {
        System.out.println("Запущен поток печати буквы b");
        synchronized (mon) {
            for (int i = 0; i < 5; i++) {
                while (letter != 'b') {
                    try {
                        System.out.println("Вызван метод wait  в потоке b");
                        mon.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(letter);
                letter = 'c';
                mon.notifyAll();
            }
        }
    }

    public void printLetterC() {
        System.out.println("Запущен поток печати буквы c");
        synchronized (mon) {
            for (int i = 0; i < 5; i++) {
                while (letter != 'c') {
                    try {
                        System.out.println("Вызван метод wait  в потоке c");
                        mon.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(letter);
                letter = 'a';
                mon.notifyAll();
            }
        }
    }
}
