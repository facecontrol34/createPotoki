class PeopleQueue extends Thread    {
    private String[] names;

    PeopleQueue(String... names) {
        this.names = names;
    }

    @Override
    public void run() {
        for (int i = 0; i < names.length; i++) {
            System.out.println("Обработаны никнеймы: " + names[i]);
            try {
                sleep(500);
            } catch (Exception e) {}
        }
    }
}

public class HR {
    public static void main(String[] args) {
        // Создаем две очереди
        PeopleQueue queue1 = new PeopleQueue("s1mple", "Electronic", "b1t", "sdy", "perfecto");
        PeopleQueue queue2 = new PeopleQueue("nafany", "sh1ro", "Axile", "Hobbit", "interz");

        System.out.println("Погнали!");
        queue1.start();
        queue2.start();
    }
}
