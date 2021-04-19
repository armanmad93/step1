package homework2;

import homework2.controller.Controller;

import static homework2.randomAddPeoples.RandomGeneratePeople.randomGeneratePeople;

public class Main {
    public static void main(String[] args) {

        randomGeneratePeople(10);
        Controller controller = new Controller();

        controller.startProgramControl();

    }
}
