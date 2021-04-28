package com.company;

import com.company.controller.Controller;
import com.company.model.TechnicalTask;
import com.company.model.*;

//1. Отримати список технічних
//        завдань для заданого призначення.
//        2. Отримати список технічних
//        завдань, які потребують заданої
//        кваліфікації.

public class Main {

    public static void main(String[] args) {
	// write your code here
        Controller controller = new Controller();
        controller.calculate();
    }
}
