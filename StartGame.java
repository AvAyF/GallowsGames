public class StartGame {

    public static void main(String[] args) {
        System.out.print("Внимание! Внимание! Внимание! Глаголетъ Царь.\n" +
                "Азъ есмь Царь, и во тьмѣ нощной привиде ми ся слово.\n" +
                "Иже изъ присѣтныхъ здѣ сущихъ возможетъ слово узрѣти,\n" +
                "да будетъ награжденъ.\n" +
                "Аще же не возможете, то будете послани \n" +
                "НА ВИСИЛИЦУ!\n");

        BackGround world = new BackGround("Забулдыжничество");
        world.startGame();
    }
}
