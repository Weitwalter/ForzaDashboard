package wauz.forza.dashboard.frontend;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.DoubleBinding;
import javafx.beans.binding.DoubleExpression;
import javafx.beans.binding.StringExpression;
import javafx.beans.property.*;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import wauz.forza.dashboard.backend.DataEngineer;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Inet4Address;
import java.nio.file.Paths;
import java.util.Properties;

public class ForzaGuiController {
    @FXML
    ProgressBar progressWheelInPuddleDepthFL;
    @FXML
    ProgressBar progressWheelInPuddleDepthFR;
    @FXML
    ProgressBar progressWheelInPuddleDepthRL;
    @FXML
    ProgressBar progressWheelInPuddleDepthRR;
    @FXML
    ProgressBar progressSurfaceRumbleFL;
    @FXML
    ProgressBar progressSurfaceRumbleFR;
    @FXML
    ProgressBar progressSurfaceRumbleRL;
    @FXML
    ProgressBar progressSurfaceRumbleRR;
    @FXML
    ProgressBar progressWheelOnRumbleStrupFL;
    @FXML
    ProgressBar progressWheelOnRumbleStrupFR;
    @FXML
    ProgressBar progressWheelOnRumbleStrupRL;
    @FXML
    ProgressBar progressWheelOnRumbleStrupRR;
    @FXML
    Label labelAddressLocalIP;
    @FXML
    Label labelAddressLocalPort;
    @FXML
    Label labelTireSlipRatioFL;
    @FXML
    Label labelTireSlipAngleFL;
    @FXML
    Label labelTireSlipCombinedFL;
    @FXML
    Label labelTireSlipRatioFR;
    @FXML
    Label labelTireSlipAngleFR;
    @FXML
    Label labelTireSlipCombinedFR;
    @FXML
    Label labelTireSlipRatioRL;
    @FXML
    Label labelTireSlipAngleRL;
    @FXML
    Label labelTireSlipCombinedRL;
    @FXML
    Label labelTireSlipRatioRR;
    @FXML
    Label labelTireSlipAngleRR;
    @FXML
    Label labelTireSlipCombinedRR;

    @FXML
    Label labelSurfaceRumbleFL;

    @FXML
    Label labelSurfaceRumbleFR;

    @FXML
    Label labelSurfaceRumbleRL;

    @FXML
    Label labelSurfaceRumbleRR;
    @FXML
    Label labelWheelInPuddleDepthFL;
    @FXML
    Label labelWheelInPuddleDepthFR;
    @FXML
    Label labelWheelInPuddleDepthRL;
    @FXML
    Label labelWheelInPuddleDepthRR;
    @FXML
    Label labelRoll;
    @FXML
    Label labelPitch;
    @FXML
    Label labelYaw;
    @FXML
    Label labelRpmZero;
    @FXML
    Label labelVelocityTrueKphLabel;
    @FXML
    Label labelVelocityTrueMphLabel;
    @FXML
    Button buttonResizeDrag;
    @FXML
    Label labelShiftIndicatorRight;
    @FXML
    Label labelShiftIndicatorLeft;
    @FXML
    Label labelAlwaysOnTop;
    @FXML
    Button buttonClose;
    @FXML
    Button buttonResize;
    @FXML
    Button buttonSetCarDescription;
    @FXML
    TextField textCarDescription;
    @FXML
    Label labelCarDescription;
    @FXML
    Slider sliderShiftIndicatorThresholdLow;
    @FXML
    Label labelShiftIndicatorThresholdLow;
    @FXML
    Slider sliderShiftIndicatorThresholdHigh;
    @FXML
    Label labelShiftIndicatorThresholdHigh;
    @FXML
    StackPane stackpaneShiftWarning;
    @FXML
    ProgressBar progressShiftWarning;
    @FXML
    Label labelShiftIndicator;
    @FXML
    Label labelWheelRpmDiffLeftPerc;
    @FXML
    Label labelWheelRpmDiffLeftAbs;
    @FXML
    Label labelWheelRpmDiffRightPerc;
    @FXML
    Label labelWheelRpmDiffRightAbs;
    @FXML
    Label labelWheelRpmDiffRearPerc;
    @FXML
    Label labelWheelRpmDiffRearAbs;
    @FXML
    Label labelWheelRpmDiffFrontAbs;
    @FXML
    Label labelWheelRpmDiffFrontPerc;
    @FXML
    StackPane stackPaneSuspensionTravelFR;
    @FXML
    ProgressBar progressSuspensionTravelFR;
    @FXML
    Label labelSuspensionTravelFR;
    @FXML
    StackPane stackPaneSuspensionTravelRL;
    @FXML
    ProgressBar progressSuspensionTravelRL;
    @FXML
    Label labelSuspensionTravelRL;
    @FXML
    StackPane stackPaneSuspensionTravelRR;
    @FXML
    ProgressBar progressSuspensionTravelRR;
    @FXML
    Label labelSuspensionTravelRR;
    @FXML
    StackPane stackPaneSuspensionTravelFL;
    @FXML
    Label labelSuspensionTravelFL;
    @FXML
    ProgressBar progressSuspensionTravelFL;
    @FXML
    Label labelAccelerationX;
    @FXML
    Label labelAccelerationY;
    @FXML
    Label labelAccelerationZ;
    @FXML
    StackPane stackpaneAccelerationCurrent;
    @FXML
    Label labelDecelerationMax;
    @FXML
    Label labelAccelerationCurrent;
    @FXML
    Label labelAccelerationMax;
    @FXML
    BorderPane borderPaneRoot;
    @FXML
    StackPane stackpaneRpm;
    @FXML
    Label labelVelocityTrueNormalized;
    @FXML
    Label labelVelocityTrueKph;
    @FXML
    Label labelVelocityTrueMph;
    @FXML
    Label labelVelocityX;
    @FXML
    Label labelVelocityZ;
    @FXML
    Label labelVelocityY;
    @FXML
    Label labelAngularVelocityX;
    @FXML
    Label labelAngularVelocityY;
    @FXML
    Label labelAngularVelocityZ;
    @FXML
    Label labelAngularVelocityTrueNormalized;
    @FXML
    Label labelRpmMaxMeasured;
    @FXML
    Label labelCarPerformanceIndex;
    @FXML
    Label labelDrivetrainType;
    @FXML
    Label labelNumOfCylinders;
    @FXML
    Label labelTimestamp;
    @FXML
    Label labelRpmMax;
    @FXML
    ProgressBar progressRpmCurrent;
    @FXML
    ProgressBar progressAccelerationCurrent;
    @FXML
    ProgressBar progressDecelerationCurrent;
    @FXML
    Label labelCarOrdinal;
    @FXML
    Label labelCarClass;
    @FXML
    Label labelRpmCurrent;
    @FXML
    Label labelWheelRpmFL;
    @FXML
    Label labelWheelRpmFR;
    @FXML
    Label labelWheelRpmRL;
    @FXML
    Label labelWheelRpmRR;
    @FXML
    Button buttonAlwaysOnTop;
    @FXML
    Button buttonRpmMaxMeasuredReset;

    private Properties carConfig;
    private Properties forzaConfig;
    private DataEngineer engineer;
    private BooleanProperty alwaysOnTop = new SimpleBooleanProperty();
    private double windowOffsetX = 0;
    private double windowOffsetY = 0;
    private double windowSizeX = 0;
    private double windowSizeY = 0;
    private BooleanProperty maximized = new SimpleBooleanProperty(false);
    private DoubleProperty horizontalScale = new SimpleDoubleProperty();
    private DoubleProperty verticalScale = new SimpleDoubleProperty();
    private static final double INITIAL_HSCALE = 1000.0;
    private static final double INITIAL_VSCALE = 500.0;
    private StringProperty spAddressLocalIP = new SimpleStringProperty();
    private IntegerProperty ipAddressLocalPort = new SimpleIntegerProperty();



    public ForzaGuiController() {
        this.engineer = DataEngineer.getInstance();
    }

    @FXML
    public void initialize() {
        //bind looks
        carConfig = new Properties();
        forzaConfig = loadConfiguration(new Properties());
        alwaysOnTop.setValue(Boolean.FALSE);
        if (forzaConfig != null) {
            alwaysOnTop.setValue(Boolean.parseBoolean(forzaConfig.getProperty("alwaysOnTop")));
            ipAddressLocalPort.setValue(Integer.parseInt(forzaConfig.getProperty("listeningPort")));
            engineer.surfaceRumbleMax.setValue(Double.parseDouble(forzaConfig.getProperty("surfaceRumbleMax","3.8")));
        }

        //bind config
        labelShiftIndicatorThresholdLow.textProperty().bind(Bindings.format("%2.0f", engineer.shiftWarningThresholdLow));
        labelShiftIndicatorThresholdHigh.textProperty().bind(Bindings.format("%2.0f", engineer.shiftWarningThresholdHigh));
        sliderShiftIndicatorThresholdLow.maxProperty().setValue(98);
        sliderShiftIndicatorThresholdLow.setValue(engineer.shiftWarningThresholdLow.getValue());
        engineer.shiftWarningThresholdLow.bindBidirectional(sliderShiftIndicatorThresholdLow.valueProperty());
        sliderShiftIndicatorThresholdHigh.setValue(engineer.shiftWarningThresholdHigh.getValue());
        sliderShiftIndicatorThresholdHigh.minProperty().bind(sliderShiftIndicatorThresholdLow.valueProperty().add(1));
        engineer.shiftWarningThresholdHigh.bindBidirectional(sliderShiftIndicatorThresholdHigh.valueProperty());

        engineer.carDescription.bindBidirectional(textCarDescription.textProperty());

        //bind main information display scaling
        progressRpmCurrent.prefWidthProperty().bind(borderPaneRoot.widthProperty().multiply(0.6));
        progressRpmCurrent.prefHeightProperty().bind(borderPaneRoot.heightProperty().multiply(0.1));
        labelRpmCurrent.styleProperty().bind(Bindings.concat("-fx-font-size: ",verticalScale.multiply(35),";"));
        labelRpmZero.styleProperty().bind(Bindings.concat("-fx-font-size: ",verticalScale.multiply(24),";"));
        labelRpmMax.styleProperty().bind(Bindings.concat("-fx-font-size: ",verticalScale.multiply(24),";"));

        progressShiftWarning.prefHeightProperty().bind(borderPaneRoot.heightProperty().multiply(0.06));
        progressShiftWarning.prefWidthProperty().bind(borderPaneRoot.widthProperty().multiply(0.7));
        labelShiftIndicator.styleProperty().bind(Bindings.concat("-fx-font-size: ",verticalScale.multiply(16),";"));
        labelShiftIndicatorLeft.styleProperty().bind(Bindings.concat("-fx-font-size: ",verticalScale.multiply(16),";"));
        labelShiftIndicatorRight.styleProperty().bind(Bindings.concat("-fx-font-size: ",verticalScale.multiply(16),";"));

        labelVelocityTrueKph.styleProperty().bind(Bindings.concat("-fx-font-size: ",verticalScale.multiply(50),";"));
        labelVelocityTrueKphLabel.styleProperty().bind(Bindings.concat("-fx-font-size: ",verticalScale.multiply(24),";"));
        labelVelocityTrueMph.styleProperty().bind(Bindings.concat("-fx-font-size: ",verticalScale.multiply(24),";"));
        labelVelocityTrueMphLabel.styleProperty().bind(Bindings.concat("-fx-font-size: ",verticalScale.multiply(24),";"));


        //bind data
        DoubleBinding normalizedRpmCurrent = engineer.rpmCurrent.divide(engineer.rpmMax);
        progressRpmCurrent.progressProperty().bind(normalizedRpmCurrent);
        progressShiftWarning.progressProperty().bind(engineer.shiftWarning);
        labelShiftIndicator.textProperty().bind(Bindings.format("%3.0f", engineer.shiftWarning.subtract(1).multiply(-100)));
        labelShiftIndicatorLeft.textProperty().bind(Bindings.format("%5.0f", engineer.rpmMaxMeasured.multiply(engineer.shiftWarningThresholdLow.divide(100))));
        labelShiftIndicatorRight.textProperty().bind(Bindings.format("%5.0f", engineer.rpmMaxMeasured.multiply(engineer.shiftWarningThresholdHigh.divide(100))));


        progressAccelerationCurrent.progressProperty().bind(engineer.normalizedAccelerationTrue);
        progressDecelerationCurrent.progressProperty().bind(engineer.normalizedDecelerationTrue);
        progressSuspensionTravelFL.progressProperty().bind(engineer.suspensionTravelNormalizedFL);
        progressSuspensionTravelFR.progressProperty().bind(engineer.suspensionTravelNormalizedFR);
        progressSuspensionTravelRL.progressProperty().bind(engineer.suspensionTravelNormalizedRL);
        progressSuspensionTravelRR.progressProperty().bind(engineer.suspensionTravelNormalizedRR);

        labelRpmMax.textProperty().bind(Bindings.format("%5.0f", engineer.rpmMax));
        labelRpmCurrent.textProperty().bind(Bindings.format("%5.0f", engineer.rpmCurrent));

        labelRpmMaxMeasured.textProperty().bind(Bindings.format("%5.0f", engineer.rpmMaxMeasured));
        labelDrivetrainType.textProperty().bind(StringExpression.stringExpression(engineer.drivetrainTypeString));
        labelCarClass.textProperty().bind(StringExpression.stringExpression(engineer.carClassString));
        labelCarOrdinal.textProperty().bind(StringExpression.stringExpression(engineer.carOrdinal));
        labelCarPerformanceIndex.textProperty().bind(StringExpression.stringExpression(engineer.carPerformanceIndex));
        labelNumOfCylinders.textProperty().bind(StringExpression.stringExpression(engineer.numOfCylinders));
        labelTimestamp.textProperty().bind(Bindings.format("%.3f", DoubleExpression.doubleExpression(engineer.timestamp).divide(1000)).concat("s"));

        labelVelocityX.textProperty().bind(Bindings.format("%5.2f", engineer.velocityX));
        labelVelocityY.textProperty().bind(Bindings.format("%5.2f", engineer.velocityY));
        labelVelocityZ.textProperty().bind(Bindings.format("%5.2f", engineer.velocityZ));
        labelVelocityTrueNormalized.textProperty().bind(Bindings.format("%5.2f", engineer.velocityTrue));
        labelVelocityTrueKph.textProperty().bind(Bindings.format("%5.0f", engineer.velocityTrueKph));
        labelVelocityTrueMph.textProperty().bind(Bindings.format("%5.0f", engineer.velocityTrueMph));

        labelAngularVelocityX.textProperty().bind(Bindings.format("%5.2f", engineer.angularVelocityX));
        labelAngularVelocityY.textProperty().bind(Bindings.format("%5.2f", engineer.angularVelocityY));
        labelAngularVelocityZ.textProperty().bind(Bindings.format("%5.2f", engineer.angularVelocityZ));
        labelAngularVelocityTrueNormalized.textProperty().bind(Bindings.format("%5.5f", engineer.angularVelocityTrue));

        labelAccelerationCurrent.textProperty().bind(Bindings.format("%5.1f", engineer.accelerationZ));
        labelAccelerationX.textProperty().bind(Bindings.format("%5.2f", engineer.accelerationX));
        labelAccelerationY.textProperty().bind(Bindings.format("%5.2f", engineer.accelerationY));
        labelAccelerationZ.textProperty().bind(Bindings.format("%5.2f", engineer.accelerationZ));
        labelAccelerationMax.textProperty().bind(Bindings.format("%3.0f", engineer.accelerationMaxMeasured));
        labelDecelerationMax.textProperty().bind(Bindings.format("%3.0f", engineer.decelerationMaxMeasured));

        labelYaw.textProperty().bind(Bindings.format("%5.2f",engineer.movementYaw));
        labelPitch.textProperty().bind(Bindings.format("%5.2f",engineer.movementPitch));
        labelRoll.textProperty().bind(Bindings.format("%5.2f",engineer.movementRoll));

        labelSuspensionTravelFL.textProperty().bind(Bindings.format("%5.1f", engineer.suspensionTravelMetersFL.multiply(100)).concat("cm"));
        labelSuspensionTravelFR.textProperty().bind(Bindings.format("%5.1f", engineer.suspensionTravelMetersFR.multiply(100)).concat("cm"));
        labelSuspensionTravelRL.textProperty().bind(Bindings.format("%5.1f", engineer.suspensionTravelMetersRL.multiply(100)).concat("cm"));
        labelSuspensionTravelRR.textProperty().bind(Bindings.format("%5.1f", engineer.suspensionTravelMetersRR.multiply(100)).concat("cm"));

        labelWheelRpmFL.textProperty().bind(Bindings.format("%5.0f", engineer.wheelRotationSpeedFL.multiply(9.5493)));
        labelWheelRpmFR.textProperty().bind(Bindings.format("%5.0f", engineer.wheelRotationSpeedFR.multiply(9.5493)));
        labelWheelRpmRL.textProperty().bind(Bindings.format("%5.0f", engineer.wheelRotationSpeedRL.multiply(9.5493)));
        labelWheelRpmRR.textProperty().bind(Bindings.format("%5.0f", engineer.wheelRotationSpeedRR.multiply(9.5493)));

        labelWheelRpmDiffFrontAbs.textProperty().bind(Bindings.format("%5.0f", engineer.wheelRpmDiffFrontAbsolute).concat("/"));
        labelWheelRpmDiffFrontPerc.textProperty().bind(Bindings.format("%5.1f", engineer.wheelRpmDiffFrontPercentage).concat("%"));
        labelWheelRpmDiffRearAbs.textProperty().bind(Bindings.format("%5.0f", engineer.wheelRpmDiffRearAbsolute).concat("/"));
        labelWheelRpmDiffRearPerc.textProperty().bind(Bindings.format("%5.1f", engineer.wheelRpmDiffRearPercentage).concat("%"));
        labelWheelRpmDiffLeftAbs.textProperty().bind(Bindings.format("%5.0f", engineer.wheelRpmDiffLeftAbsolute).concat("/"));
        labelWheelRpmDiffLeftPerc.textProperty().bind(Bindings.format("%5.1f", engineer.wheelRpmDiffLeftPercentage).concat("%"));
        labelWheelRpmDiffRightAbs.textProperty().bind(Bindings.format("%5.0f", engineer.wheelRpmDiffRightAbsolute).concat("/"));

        labelWheelRpmDiffRightPerc.textProperty().bind(Bindings.format("%5.1f", engineer.wheelRpmDiffRightPercentage).concat("%"));


        labelTireSlipRatioFL.textProperty().bind(Bindings.format("%5.2f", engineer.tireSlipRatioNormalizedFL).concat("(R)"));
        labelTireSlipAngleFL.textProperty().bind(Bindings.format("%5.2f", engineer.tireSlipAngleNormalizedFL).concat("(A)"));
        labelTireSlipCombinedFL.textProperty().bind(Bindings.format("%5.2f", engineer.tireSlipCombinedNormalizedFL).concat("(C)"));

        labelTireSlipRatioFR.textProperty().bind(Bindings.format("%5.2f", engineer.tireSlipRatioNormalizedFR).concat("(R)"));
        labelTireSlipAngleFR.textProperty().bind(Bindings.format("%5.2f", engineer.tireSlipAngleNormalizedFR).concat("(A)"));
        labelTireSlipCombinedFR.textProperty().bind(Bindings.format("%5.2f", engineer.tireSlipCombinedNormalizedFR).concat("(C)"));

        labelTireSlipRatioRL.textProperty().bind(Bindings.format("%5.2f", engineer.tireSlipRatioNormalizedRL).concat("(R)"));
        labelTireSlipAngleRL.textProperty().bind(Bindings.format("%5.2f", engineer.tireSlipAngleNormalizedRL).concat("(A)"));
        labelTireSlipCombinedRL.textProperty().bind(Bindings.format("%5.2f", engineer.tireSlipCombinedNormalizedRL).concat("(C)"));

        labelTireSlipRatioRR.textProperty().bind(Bindings.format("%5.2f", engineer.tireSlipRatioNormalizedRR).concat("(R)"));
        labelTireSlipAngleRR.textProperty().bind(Bindings.format("%5.2f", engineer.tireSlipAngleNormalizedRR).concat("(A)"));
        labelTireSlipCombinedRR.textProperty().bind(Bindings.format("%5.2f", engineer.tireSlipCombinedNormalizedRR).concat("(C)"));

        progressWheelOnRumbleStrupFL.progressProperty().bind(engineer.wheelOnRumbleStripFL);
        progressWheelOnRumbleStrupFR.progressProperty().bind(engineer.wheelOnRumbleStripFR);
        progressWheelOnRumbleStrupRL.progressProperty().bind(engineer.wheelOnRumbleStripRL);
        progressWheelOnRumbleStrupRR.progressProperty().bind(engineer.wheelOnRumbleStripRR);

        progressSurfaceRumbleFL.progressProperty().bind(engineer.surfaceRumbleFL.divide(engineer.surfaceRumbleMax.getValue()));
        progressSurfaceRumbleFR.progressProperty().bind(engineer.surfaceRumbleFR.divide(engineer.surfaceRumbleMax.getValue()));
        progressSurfaceRumbleRL.progressProperty().bind(engineer.surfaceRumbleRL.divide(engineer.surfaceRumbleMax.getValue()));
        progressSurfaceRumbleRR.progressProperty().bind(engineer.surfaceRumbleRR.divide(engineer.surfaceRumbleMax.getValue()));


        labelSurfaceRumbleFL.textProperty().bind(Bindings.format("%5.0f", engineer.surfaceRumbleFL.divide(engineer.surfaceRumbleMax.getValue()).multiply(100)).concat("%"));
        labelSurfaceRumbleFR.textProperty().bind(Bindings.format("%5.0f", engineer.surfaceRumbleFR.divide(engineer.surfaceRumbleMax.getValue()).multiply(100)).concat("%"));
        labelSurfaceRumbleRL.textProperty().bind(Bindings.format("%5.0f", engineer.surfaceRumbleRL.divide(engineer.surfaceRumbleMax.getValue()).multiply(100)).concat("%"));
        labelSurfaceRumbleRR.textProperty().bind(Bindings.format("%5.0f", engineer.surfaceRumbleRR.divide(engineer.surfaceRumbleMax.getValue()).multiply(100)).concat("%"));


        labelWheelInPuddleDepthFL.textProperty().bind(Bindings.format("%5.0f", engineer.wheelInPuddleDepthFL.multiply(100)).concat("%"));
        labelWheelInPuddleDepthFR.textProperty().bind(Bindings.format("%5.0f", engineer.wheelInPuddleDepthFR.multiply(100)).concat("%"));
        labelWheelInPuddleDepthRL.textProperty().bind(Bindings.format("%5.0f", engineer.wheelInPuddleDepthRL.multiply(100)).concat("%"));
        labelWheelInPuddleDepthRR.textProperty().bind(Bindings.format("%5.0f", engineer.wheelInPuddleDepthRR.multiply(100)).concat("%"));

        progressWheelInPuddleDepthFL.progressProperty().bind(engineer.wheelInPuddleDepthFL);
        progressWheelInPuddleDepthFR.progressProperty().bind(engineer.wheelInPuddleDepthFR);
        progressWheelInPuddleDepthRL.progressProperty().bind(engineer.wheelInPuddleDepthRL);
        progressWheelInPuddleDepthRR.progressProperty().bind(engineer.wheelInPuddleDepthRR);


        labelCarDescription.textProperty().bind(StringExpression.stringExpression(engineer.carDescription));
        labelAlwaysOnTop.textProperty().bind(alwaysOnTop.asString());

        labelAddressLocalIP.textProperty().bind(spAddressLocalIP);
        labelAddressLocalPort.textProperty().bind(ipAddressLocalPort.asString());
        try {
            spAddressLocalIP.setValue(Inet4Address.getLocalHost().getHostAddress());
        } catch (Exception e){
            System.out.println("Error reading local IP: "+e.toString());
        }


        borderPaneRoot.setOnMousePressed(event -> {
            windowOffsetX = event.getSceneX();
            windowOffsetY = event.getSceneY();
        });
        borderPaneRoot.setOnMouseDragged(event -> {
            buttonResize.getScene().getWindow().setX(event.getScreenX() - windowOffsetX);
            buttonResize.getScene().getWindow().setY(event.getScreenY() - windowOffsetY);
        });

        buttonClose.setOnAction(event -> {
            //todo: clean close
            //((Stage) buttonClose.getScene().getWindow()).close();
            System.exit(0);
        });
        buttonResize.setOnAction(event -> {
            Stage tmpStage = ((Stage) buttonResize.getScene().getWindow());
            if (!maximized.getValue()) {
                tmpStage.setMaximized(true);
                buttonResize.setText("Restore Window");
                maximized.setValue(true);

            } else{
                tmpStage.setMaximized(false);
                buttonResize.setText("Maximize Window");
                maximized.setValue(false);
            }
            horizontalScale.setValue(buttonResizeDrag.getScene().getWindow().getWidth() / INITIAL_HSCALE);
            verticalScale.setValue(buttonResizeDrag.getScene().getWindow().getHeight() / INITIAL_VSCALE);

        });
        buttonResizeDrag.setOnMousePressed(event -> {
            windowSizeX = buttonResizeDrag.getScene().getWindow().getWidth() - event.getX();
            windowSizeY = buttonResizeDrag.getScene().getWindow().getHeight() - event.getY();
        });
        buttonResizeDrag.setOnMouseDragged(event -> {
            //todo: clean up quirkiness of this.
            buttonResizeDrag.getScene().getWindow().setWidth(event.getX() + windowSizeX);
            buttonResizeDrag.getScene().getWindow().setHeight(event.getY() + windowSizeY);
            horizontalScale.setValue(buttonResizeDrag.getScene().getWindow().getWidth() / INITIAL_HSCALE);
            verticalScale.setValue(buttonResizeDrag.getScene().getWindow().getHeight() / INITIAL_VSCALE);

        });

        buttonAlwaysOnTop.setOnAction(event -> {
            if (alwaysOnTop.getValue()) {
                ((Stage) buttonAlwaysOnTop.getScene().getWindow()).setAlwaysOnTop(false);
                buttonAlwaysOnTop.textProperty().setValue("Switch On");
                alwaysOnTop.setValue(false);

            } else {
                ((Stage) buttonAlwaysOnTop.getScene().getWindow()).setAlwaysOnTop(true);
                buttonAlwaysOnTop.textProperty().setValue("Switch Off");
                alwaysOnTop.setValue(true);
            }
        });

        buttonSetCarDescription.setOnAction(event -> {
            if (engineer.carDescription.getValue() == null) engineer.carDescription.setValue("unknown car");
            int result = saveCarSettings();
            System.out.println("Saving Car: " + engineer.carDescription.getValue() + " / " + engineer.carOrdinal.getValue().toString() + " / " + Integer.toString(result));
        });


        //Save Car Settings to File
        engineer.isRaceOn.addListener((observable, oldValue, newValue) -> {
            //only save when entering the menu
            if (engineer.isRaceOn.getValue() == 0) {
                if (engineer.carDescription.getValue() == null) engineer.carDescription.setValue("unknown car");
                int result = saveCarSettings();
                System.out.println("Saving Car: " + engineer.carDescription.getValue() + " / " + engineer.carOrdinal.getValue().toString() + " / " + Integer.toString(result));
            }
        });

        //read Car Settings from File
        engineer.carOrdinal.addListener((observable, oldValue, newValue) -> {
            engineer.carDescription.setValue("unknown car");
            int result = loadCarSettings();
            System.out.println("Loaded Car: " + engineer.carDescription.getValue() + "/" + Integer.toString(result));
        });
        buttonRpmMaxMeasuredReset.setOnAction(event -> {
            engineer.rpmMaxMeasured.setValue(1);
        });

    }

    private Properties loadConfiguration(Properties newConfiguration) {
        try {
            InputStream configReader = new FileInputStream(Paths.get("").toAbsolutePath().toString() + "/ForzaConfig.properties");
            newConfiguration.load(configReader);
            return newConfiguration;
        } catch (Exception e) {
            System.out.println("Could not load config: " + e.toString());
            return null;
        }

    }

    private int loadCarSettings() {
        try {
            InputStream carConfigReader = new FileInputStream(Paths.get("").toAbsolutePath().toString() + "/ForzaCarSettings.properties");
            carConfig.load(carConfigReader);
            engineer.rpmMaxMeasured.setValue(Double.parseDouble(carConfig.getProperty(engineer.carOrdinal.getValue().toString() + "_RpmMaxMeasured", "0")));
            if (engineer.rpmMaxMeasured.getValue() > 0) {
                engineer.carDescription.setValue(carConfig.getProperty(engineer.carOrdinal.getValue().toString() + "_CarDescription", "unknown car"));
                engineer.shiftWarningThresholdLow.setValue(Double.parseDouble(carConfig.getProperty(engineer.carOrdinal.getValue().toString() + "_ShiftWarningThresholdLow")));
                engineer.shiftWarningThresholdHigh.setValue(Double.parseDouble(carConfig.getProperty(engineer.carOrdinal.getValue().toString() + "_ShiftWarningThresholdHigh")));
            }
            engineer.isRaceOn.setValue(1);
        } catch (Exception e) {
            System.out.println("Could not Load car: " + e.toString());
        }
        return 1;
    }

    private int saveCarSettings() {
        if (engineer.carOrdinal.getValue() > 0) {
            try {
                carConfig.setProperty(engineer.carOrdinal.getValue().toString() + "_RpmMaxMeasured", engineer.rpmMaxMeasured.getValue().toString());
                carConfig.setProperty(engineer.carOrdinal.getValue().toString() + "_ShiftWarningThresholdLow", engineer.shiftWarningThresholdLow.getValue().toString());
                carConfig.setProperty(engineer.carOrdinal.getValue().toString() + "_ShiftWarningThresholdHigh", engineer.shiftWarningThresholdHigh.getValue().toString());
                carConfig.setProperty(engineer.carOrdinal.getValue().toString() + "_CarDescription", engineer.carDescription.getValue());


                OutputStream carConfigWriter = new FileOutputStream(Paths.get("").toAbsolutePath().toString() + "/ForzaCarSettings.properties");
                carConfig.store(carConfigWriter, "Saved");

            } catch (Exception e) {
                System.out.println("Could not save car: " + e.toString());
            }

        }
        return 1;
    }

}
