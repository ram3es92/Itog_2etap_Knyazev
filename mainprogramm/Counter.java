package Itog_2etap_Knyazev.mainprogramm;

public class Counter implements AutoCloseable {
    private int count = 0;
    private boolean closed = false;

    public void add() throws Exception {
        if (closed) {
            throw new Exception("Ошибка: попытка использовать закрытый ресурс Counter.");
        }
        count++;
        System.out.println("Количество добавленных животных: " + count);
    }

    @Override
    public void close() {
        closed = true;
        System.out.println("Ресурс Counter закрыт.");
    }
}