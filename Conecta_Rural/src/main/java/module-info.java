module com.conectarural.conecta_rural {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.bootstrapfx.core;

    opens com.conectarural.conecta_rural to javafx.fxml;
    exports com.conectarural.conecta_rural;
}