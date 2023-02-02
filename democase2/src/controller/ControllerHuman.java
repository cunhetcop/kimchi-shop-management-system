package controller;

import models.Student;
import services.HumanService;
import views.ViewHuman;

public class ControllerHuman {
    public static void menuManagerUser() {
        ViewHuman viewHuman = new ViewHuman();
        HumanService humanService = new HumanService();

        while (true) {
            int choice = viewHuman.menuUser();
            switch (choice) {
                case 1:
                    int choiceAdd = viewHuman.menuAdd();
                    switch (choiceAdd) {
                        case 1:
                            humanService.save(viewHuman.creteHuman(true));
                            break;
                        case 2:
                            humanService.save(viewHuman.creteHuman(false));
                            break;
                    }
                    break;

                case 2:
                    int index = humanService.findIndexByName(viewHuman.inputName());
                    if (index != -1) {
                        if (humanService.findAll().get(index) instanceof Student) {
                            humanService.edit(index, viewHuman.creteHuman(true));
                        } else {
                            humanService.edit(index, viewHuman.creteHuman(false));
                        }
                    }
                    break;
                case 5:
                    return;
                case 4:
                    viewHuman.show(humanService.findAll());
                    break;
            }
        }

    }

    public static void menuManagerAdmin() {
        ViewHuman viewHuman = new ViewHuman();
        while (true) {
            int choice = viewHuman.menuAdmin();
        }

    }
}
