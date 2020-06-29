public class Main {
        private static Object mon = new Object();
        private static char curLet = 'A';

    public static void main(String[] args) {
        //Main t1 = new Main();
        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();
        MyThread t3 = new MyThread();

       // t1.printLetter('A','B');
      //  t1.printLetter('B','C');
       // t1.printLetter('C','A');

       new Thread(() -> t1.printLetter('A','B') ).start();
       new Thread(() -> t2.printLetter('B','C') ).start();
       new Thread(() -> t3.printLetter('C','A') ).start();



   }

    public void printLetter(char c , char nextLet) {
           //System.out.println("Запущен поток печати буквы " + curLet);
        synchronized (mon) {
            for (int i = 0; i < 5; i++) {
                try {
                    while (Main.curLet != c) {
                        //System.out.println("Вызван метод wait  в потоке " + curLet);
                        mon.wait();
                    }
                    System.out.print(curLet);
                    curLet = nextLet;
                    mon.notifyAll();
                    } catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
    }
}
