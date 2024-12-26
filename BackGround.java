import java.util.Scanner;

public final class BackGround {
    private final int countLetter; //длина слова
    private final String world; //Загаданное слово
    private String worldClear; //Прочерки у загаданного слова
    private int countTry; //Количество попыток
    private String lastLetter; //Последняя введённая буква

    //Конструктор переменных
    public BackGround(String world) {
        this.countLetter = world.length();
        this.world = world.toUpperCase();
        this.worldClear = worldClear();
        this.countTry = setTryLast();
    }

    //Создаём пустое слово равное кол-ву букв
    public String worldClear() {
        return "_".repeat(this.countLetter);
    }

    //Установка количества попыток
    public int setTryLast() {
        countTry = (int) (countLetter * 1.5d);
        return countTry;
    }

    //Запуск игры, и проверка на её окончание
    public void startGame() {
        if (countTry < 1) { //кол-во попыток
            theEndBad();
        } else {
            if (world.equals(worldClear)) { //если отгадал слово
                theEndGood();
            } else {
                getLetter(); //продолжаем игру
            }
        }
    }

    //проверка на только одну введённую букву рекурсия или отправляем в поиск findLetter
    public void getLetter() {
        System.out.println("***********************************************" +
                "\nЗагадано слово из " + countLetter + " букв: " + this.worldClear + "\nПрореци букву.");
        Scanner search = new Scanner(System.in);
        String letter = search.nextLine().toUpperCase();
        if (letter.length() > 1) {
            System.out.println("Прореци только одну букву.");
            getLetter();
        } lastLetter = letter;
        findLetter();
    }

    //Ищем букву в слове и подставляем в worldClear если она есть, если нет то снимаем кол-во попыток
    public void findLetter() {
        int indexLetter = world.indexOf(lastLetter); // Ищем символ в строке
        if (indexLetter == -1) {
            System.out.printf("Буква " + lastLetter + " не найдена.\n");
            countTry--;
            System.out.println("Осталось: " + countTry + " попыток.");
            startGame(); //рекурсия???
        } else {
            System.out.printf("Буква " + lastLetter + " имѣ есть.\n");
            worldClear = worldClear.substring(0, indexLetter) + lastLetter + worldClear.substring(indexLetter + 1);
            System.out.println(worldClear);
            startGame(); //рекурсия???
        }
    }

    //Окончание игры - победа
    public void theEndGood() {
        System.out.println("Вы отгадали слово: " + worldClear +
                "\nСколь несправедлива судьба, придётся попрощаться..." +
                "\nКазнить нельзя, помиловать!");
    }
    //Окончание игры - проигрыш
    public void theEndBad() {
        System.out.println("Вы не отгадали слово: " + worldClear +
                "\nСправедливость восторжествовала!" +
                "\nОтправить на виселицу!" +
                "\nКазнить, нельзя помиловать!");
    }
}
