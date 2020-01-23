package by.tsarionok.service;

import by.tsarionok.controller.ClientUI;
import by.tsarionok.dao.TravelCompanyDao;
import by.tsarionok.entity.*;

public class FromMenuToMenu {
    private ClientUI clientUI;
    private Voucher voucher;
    private TravelCompanyDao travelCompanyDao = TravelCompanyDao.getInstance();

    public FromMenuToMenu() {
        clientUI = ClientUI.getInstance();

    }

    public int travelFromMainMenu() {
        int choose = clientUI.mainMenuChoose();
        switch (choose) {
            case 1: {
                travelFromCruiseMenu();
                break;
            }
            case 2: {
                travelFromExcursionMenu();
                break;
            }
            case 3: {
                travelFromRelaxMenu();
                break;
            }
            case 4: {
                travelFromTherapeuticMenu();
                break;
            }
            default: {
                System.out.println("Repeat enter! (From 1 to 4)");
                travelFromMainMenu();
            }
        }
        return choose;
    }

    public void travelFromCruiseMenu() {
        voucher = new CruiseVoucher();
        switch (clientUI.cruiseChoose()) {
            case 1: {
                voucher.setGuiding(CruiseType.SEA);
                break;
            }
            case 2: {
                voucher.setGuiding(CruiseType.RIVER);
                break;
            }
            default: {
                System.out.println("Repeat enter! (From 1 to 2)");
                travelFromCruiseMenu();
            }
        }
    }

    public void travelFromExcursionMenu() {
        voucher = new ExcursionVoucher();
        switch (clientUI.excursionChoose()) {
            case 1: {
                voucher.setGuiding(ExcursionType.ONE_DAY);
                break;
            }
            case 2: {
                voucher.setGuiding(ExcursionType.MANY_DAY);
                break;
            }
            default: {
                System.out.println("Repeat enter! (From 1 to 2)");
                travelFromExcursionMenu();
            }
        }
    }

    public void travelFromRelaxMenu() {
        voucher = new RelaxVoucher();
        switch (clientUI.relaxChoose()) {
            case 1: {
                voucher.setGuiding(RelaxType.SEA);
                break;
            }
            case 2: {
                voucher.setGuiding(RelaxType.MOUNTAINS);
                break;
            }
            default: {
                System.out.println("Repeat enter! (From 1 to 2)");
                travelFromRelaxMenu();
            }
        }
    }

    public void travelFromTherapeuticMenu() {
        voucher = new TherapeuticVoucher();
        switch (clientUI.therapyChoose()) {
            case 1: {
                voucher.setGuiding(TherapeuticType.FITNESS);
                break;
            }
            case 2: {
                voucher.setGuiding(TherapeuticType.SPA);
                break;
            }
            case 3: {
                voucher.setGuiding(TherapeuticType.WEIGHT_LOSS);
                break;
            }
            default: {
                System.out.println("Repeat enter! (From 1 to 3)");
                travelFromTherapeuticMenu();
            }
        }
    }

    public void travelFromTransportMenu() {
        switch (clientUI.transportChoise()) {
            case 1: {
                voucher.setTransportType(TransportType.CAR);
                break;
            }
            case 2: {
                voucher.setTransportType(TransportType.PLAIN);
                break;
            }
            case 3: {
                voucher.setTransportType(TransportType.BUS);
                break;
            }
            case 4: {
                voucher.setTransportType(TransportType.LINER);
                break;
            }
            default: {
                System.out.println("Repeat enter! (From 1 to 4)");
                travelFromTransportMenu();
            }
        }
    }

    public void travelFromFoodMenu() {
        switch (clientUI.foodChoise()) {
            case 1: {
                voucher.setFoodType(FoodType.MEAT);
                break;
            }
            case 2: {
                voucher.setFoodType(FoodType.FISH);
                break;
            }
            case 3: {
                voucher.setFoodType(FoodType.VEGETABLES);
                break;
            }
            case 4: {
                voucher.setFoodType(FoodType.FRUITS);
                break;
            }
            case 5: {
                voucher.setFoodType(FoodType.EGGS);
                break;
            }
            default: {
                System.out.println("Repeat enter! (From 1 to 5)");
                travelFromFoodMenu();
            }
        }
    }

    public void enterDaysAmount() {
        voucher.setDayAmount(clientUI.daysEnter());
    }

    public void enterCost() {
        voucher.setPrice(clientUI.costEnter());
    }

    public void saveVoucherInBase() {
        travelCompanyDao.writeVoucher(voucher);
        travelCompanyDao.readVoucher();
    }
}
