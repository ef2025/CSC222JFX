// comment!
module main {
    requires javafx.media;
    requires javafx.controls;
    requires javafx.fxml;
    requires jakarta.xml.bind;
    requires jakarta.activation;
    requires jdk.xml.dom;

    opens com.jfx.c222jfx to javafx.fxml;
    opens shoppinglist to javafx.fxml, jakarta.xml.bind;
    opens calculator to javafx.fxml;
    opens calculatorsolution to  javafx.fxml;
    exports com.jfx.c222jfx;
    exports shoppinglist;
    exports myjavafx;
    exports multiplestagedemo;
    exports buttoninpane;
    exports showcircle;
    exports showcirclecentered;
    exports bindingdemo;
    exports nodestylerotatedemo;
    exports clock;
    exports unit15.loancalculator;
    exports unit15.eventhandler;
    exports unit15.controlcircle;
    exports unit15.anonymoushandler;
    exports unit15.controlcircle2;
    exports unit15.controlcircle3;
    exports unit15.keyevent;
    exports unit15.mouseevent;
    exports unit15.observable;
    exports unit15.innerclass;
    exports unit15.animation;
    exports unit16;
    exports programmingassignment2;
    exports calculator;
    exports calculatorsolution;
}