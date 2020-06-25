public class MyThread extends Thread {
    String[] printPosition = new String[]{"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
    String theWord;

    public MyThread(String theWord) {
        this.theWord = theWord;
        start();
    }

    @Override
    public void run() {
        printLetter(theWord);
    }

    public synchronized void printLetter(String letter) {
        for (int i = 0; i < 3; i++) {
            System.out.println(letter);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
