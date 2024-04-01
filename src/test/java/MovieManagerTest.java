import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MovieManagerTest {

    @Test
    public void findAddFilms() {
        MovieManager manager = new MovieManager();

        manager.addMovie("Бладшот");
        manager.addMovie("Вперёд");
        manager.addMovie("Отель 'Белград'");

        String[] expected = {"Бладшот", "Вперёд", "Отель 'Белград'"};
        String[] actual = manager.findAll();
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void lastFilms() {
        MovieManager manager = new MovieManager();

        manager.addMovie("Бладшот");
        manager.addMovie("Вперёд");
        manager.addMovie("Отель 'Белград'");

        String[] expected = {"Отель 'Белград'", "Вперёд", "Бладшот"};
        String[] actual = manager.findLast();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void lessLimit() {
        MovieManager manager = new MovieManager(5);

        manager.addMovie("Бладшот");
        manager.addMovie("Вперёд");
        manager.addMovie("Отель 'Белград'");
        manager.addMovie("Джентльмены");

        String[] expected = {"Джентльмены", "Отель 'Белград'", "Вперёд", "Бладшот"};
        String[] actual = manager.findLast();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void Limit() {
        MovieManager manager = new MovieManager(5);

        manager.addMovie("Бладшот");
        manager.addMovie("Вперёд");
        manager.addMovie("Отель 'Белград'");
        manager.addMovie("Джентльмены");
        manager.addMovie("Человек-невидимка");

        String[] expected = {"Человек-невидимка", "Джентльмены", "Отель 'Белград'", "Вперёд", "Бладшот"};
        String[] actual = manager.findLast();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void MoreLimit() {
        MovieManager manager = new MovieManager(5);

        manager.addMovie("Бладшот");
        manager.addMovie("Вперёд");
        manager.addMovie("Отель 'Белград'");
        manager.addMovie("Джентльмены");
        manager.addMovie("Человек-невидимка");
        manager.addMovie("Тролли. Мировой тур");

        String[] expected = {"Тролли. Мировой тур", "Человек-невидимка", "Джентльмены", "Отель 'Белград'", "Вперёд"};
        String[] actual = manager.findLast();
        Assertions.assertArrayEquals(expected, actual);
    }
}