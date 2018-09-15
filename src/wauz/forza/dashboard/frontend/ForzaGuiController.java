package wauz.forza.dashboard.frontend;

import com.sun.javafx.binding.StringFormatter;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.DoubleBinding;
import javafx.beans.binding.DoubleExpression;
import javafx.beans.binding.StringExpression;
import javafx.beans.property.*;
import javafx.fxml.FXML;
import javafx.scene.Node;
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
    ProgressBar progressRaceNormalizedDrivingLine;
    @FXML
    ProgressBar progressRaceNormalizedAIBrakeDifference;
    @FXML
    ProgressBar progressCarAccel;
    @FXML
    ProgressBar progressCarBrake;
    @FXML
    ProgressBar progressCarClutch;
    @FXML
    ProgressBar progressCarHandbrake;
    @FXML
    ProgressBar progressCarSteer;
    @FXML
    ProgressBar progressRaceFuel;
    @FXML
    Slider sliderTemperatureUnits;
    @FXML
    ProgressBar progressTireSlipAngleIndicatedFL;
    @FXML
    ProgressBar progressTireSlipAngleIndicatedRL;
    @FXML
    ProgressBar progressTireSlipAngleIndicatedFR;
    @FXML
    ProgressBar progressTireSlipAngleIndicatedRR;
    @FXML
    ProgressBar progressTireSlipAngleFL;
    @FXML
    ProgressBar progressTireSlipAngleFR;
    @FXML
    ProgressBar progressTireSlipAngleRL;
    @FXML
    ProgressBar progressTireSlipAngleRR;
    @FXML
    ProgressBar progressTireSlipIndicatedFL;
    @FXML
    ProgressBar progressTireSlipIndicatedFR;
    @FXML
    ProgressBar progressTireSlipIndicatedRR;
    @FXML
    ProgressBar progressTireSlipIndicatedRL;
    @FXML
    TabPane tpDetailInfo;
    @FXML
    ProgressBar progressTireSlipRatioFL;
    @FXML
    ProgressBar progressTireSlipRatioFR;
    @FXML
    ProgressBar progressTireSlipRatioRL;
    @FXML
    ProgressBar progressTireSlipRatioRR;
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
    ProgressBar progressWheelOnRumbleStripFL;
    @FXML
    ProgressBar progressWheelOnRumbleStripFR;
    @FXML
    ProgressBar progressWheelOnRumbleStripRL;
    @FXML
    ProgressBar progressWheelOnRumbleStripRR;
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

    //v2 (Dash) stuff:
    @FXML
    Label labelCarPositionX;
    @FXML
    Label labelCarPositionY;
    @FXML
    Label labelCarPositionZ;
    @FXML
    Label labelCarSpeed;
    @FXML
    Label labelCarPower;
    @FXML
    Label labelCarTorque;
    @FXML
    Label labelTireTempFL;
    @FXML
    Label labelTireTempFR;
    @FXML
    Label labelTireTempRL;
    @FXML
    Label labelTireTempRR;

    @FXML
    Label labelCarBoost;
    @FXML
    Label labelRaceFuel;
    @FXML
    Label labelRaceDistanceTravelled;
    @FXML
    Label labelRaceBestLap;
    @FXML
    Label labelRaceLastLap;
    @FXML
    Label labelRaceCurrentLap;
    @FXML
    Label labelRaceCurrentRaceTime;

    @FXML
    Label labelRaceLapNumber;
    @FXML
    Label labelRacePosition;

    @FXML
    Label labelCarAccel;
    @FXML
    Label labelCarBrake;
    @FXML
    Label labelCarClutch;
    @FXML
    Label labelCarHandbrake;
    @FXML
    Label labelCarGear;
    @FXML
    Label labelCarGearLabel;
    @FXML
    Label labelCarSteer;

    @FXML
    Label labelRaceNormalizedDrivingLine;
    @FXML
    Label labelRaceNormalizedAIBrakeDifference;

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
    private double scaledFontSize;
    private static final double INITIAL_FONTSIZE = 12;
    private IntegerProperty temperatureUnits = new SimpleIntegerProperty();


    public ForzaGuiController() {
        this.engineer = DataEngineer.getInstance();
    }

    @FXML
    public void initialize() {

        //bind looks
        scaledFontSize = INITIAL_FONTSIZE;
        carConfig = new Properties();
        forzaConfig = loadConfiguration(new Properties());
        alwaysOnTop.setValue(Boolean.FALSE);
        if (forzaConfig != null) {
            alwaysOnTop.setValue(Boolean.parseBoolean(forzaConfig.getProperty("alwaysOnTop")));
            ipAddressLocalPort.setValue(Integer.parseInt(forzaConfig.getProperty("listeningPort")));
            engineer.surfaceRumbleMax.setValue(Double.parseDouble(forzaConfig.getProperty("surfaceRumbleMax", "3.8")));
            temperatureUnits.setValue(Integer.parseInt(forzaConfig.getProperty("temperatureUnits", "0")));
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
        progressRpmCurrent.prefWidthProperty().bind(borderPaneRoot.widthProperty().multiply(0.45));
        progressRpmCurrent.prefHeightProperty().bind(borderPaneRoot.heightProperty().multiply(0.1));
        labelRpmCurrent.styleProperty().bind(Bindings.concat("-fx-font-size: ", verticalScale.multiply(35), ";"));
        labelRpmZero.styleProperty().bind(Bindings.concat("-fx-font-size: ", verticalScale.multiply(24), ";"));
        labelRpmMax.styleProperty().bind(Bindings.concat("-fx-font-size: ", verticalScale.multiply(24), ";"));

        progressShiftWarning.prefHeightProperty().bind(borderPaneRoot.heightProperty().multiply(0.06));
        progressShiftWarning.prefWidthProperty().bind(borderPaneRoot.widthProperty().multiply(0.7));
        labelShiftIndicator.styleProperty().bind(Bindings.concat("-fx-font-size: ", verticalScale.multiply(16), ";"));
        labelShiftIndicatorLeft.styleProperty().bind(Bindings.concat("-fx-font-size: ", verticalScale.multiply(16), ";"));
        labelShiftIndicatorRight.styleProperty().bind(Bindings.concat("-fx-font-size: ", verticalScale.multiply(16), ";"));

        labelVelocityTrueKph.styleProperty().bind(Bindings.concat("-fx-font-size: ", verticalScale.multiply(50), ";"));
        labelVelocityTrueKphLabel.styleProperty().bind(Bindings.concat("-fx-font-size: ", verticalScale.multiply(24), ";"));
        labelVelocityTrueMph.styleProperty().bind(Bindings.concat("-fx-font-size: ", verticalScale.multiply(24), ";"));
        labelVelocityTrueMphLabel.styleProperty().bind(Bindings.concat("-fx-font-size: ", verticalScale.multiply(24), ";"));

        labelCarGear.styleProperty().bind(Bindings.concat("-fx-font-size: ", verticalScale.multiply(72), ";"));
        labelCarGearLabel.styleProperty().bind(Bindings.concat("-fx-font-size: ", verticalScale.multiply(24), ";"));


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

        labelYaw.textProperty().bind(Bindings.format("%5.2f", engineer.movementYaw.multiply(57.2958)).concat("°"));
        labelPitch.textProperty().bind(Bindings.format("%5.2f", engineer.movementPitch.multiply(57.2958)).concat("°"));
        labelRoll.textProperty().bind(Bindings.format("%5.2f", engineer.movementRoll.multiply(57.2958)).concat("°"));

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


        labelTireSlipRatioFL.textProperty().bind(Bindings.format("%5.1f", engineer.tireSlipRatioNormalizedFL));
        progressTireSlipRatioFL.progressProperty().bind(engineer.tireSlipRatioAbsoluteFL);
        labelTireSlipAngleFL.textProperty().bind(Bindings.format("%5.1f", engineer.tireSlipAngleNormalizedFL));
        progressTireSlipAngleFL.progressProperty().bind(engineer.tireSlipAngleAbsoluteFL);
        labelTireSlipCombinedFL.textProperty().bind(Bindings.format("%5.1f", engineer.tireSlipCombinedNormalizedFL).concat("(C)"));

        labelTireSlipRatioFR.textProperty().bind(Bindings.format("%5.1f", engineer.tireSlipRatioNormalizedFR));
        progressTireSlipRatioFR.progressProperty().bind(engineer.tireSlipRatioAbsoluteFR);
        labelTireSlipAngleFR.textProperty().bind(Bindings.format("%5.1f", engineer.tireSlipAngleNormalizedFR));
        progressTireSlipAngleFR.progressProperty().bind(engineer.tireSlipAngleAbsoluteFR);
        labelTireSlipCombinedFR.textProperty().bind(Bindings.format("%5.1f", engineer.tireSlipCombinedNormalizedFR).concat("(C)"));

        labelTireSlipRatioRL.textProperty().bind(Bindings.format("%5.1f", engineer.tireSlipRatioNormalizedRL));
        progressTireSlipRatioRL.progressProperty().bind(engineer.tireSlipRatioAbsoluteRL);
        labelTireSlipAngleRL.textProperty().bind(Bindings.format("%5.1f", engineer.tireSlipAngleNormalizedRL));
        progressTireSlipAngleRL.progressProperty().bind(engineer.tireSlipAngleAbsoluteRL);
        labelTireSlipCombinedRL.textProperty().bind(Bindings.format("%5.1f", engineer.tireSlipCombinedNormalizedRL).concat("(C)"));

        labelTireSlipRatioRR.textProperty().bind(Bindings.format("%5.1f", engineer.tireSlipRatioNormalizedRR));
        progressTireSlipRatioRR.progressProperty().bind(engineer.tireSlipRatioAbsoluteRR);
        labelTireSlipAngleRR.textProperty().bind(Bindings.format("%5.1f", engineer.tireSlipAngleNormalizedRR));
        progressTireSlipAngleRR.progressProperty().bind(engineer.tireSlipAngleAbsoluteRR);
        labelTireSlipCombinedRR.textProperty().bind(Bindings.format("%5.1f", engineer.tireSlipCombinedNormalizedRR).concat("(C)"));

        progressTireSlipIndicatedFL.progressProperty().bind(DoubleExpression.numberExpression(engineer.tireSlipRatioIndicatedFL));
        progressTireSlipIndicatedFR.progressProperty().bind(DoubleExpression.numberExpression(engineer.tireSlipRatioIndicatedFR));
        progressTireSlipIndicatedRL.progressProperty().bind(DoubleExpression.numberExpression(engineer.tireSlipRatioIndicatedRL));
        progressTireSlipIndicatedRR.progressProperty().bind(DoubleExpression.numberExpression(engineer.tireSlipRatioIndicatedRR));

        progressTireSlipAngleIndicatedFL.progressProperty().bind(DoubleExpression.numberExpression(engineer.tireSlipAngleIndicatedFL));
        progressTireSlipAngleIndicatedFR.progressProperty().bind(DoubleExpression.numberExpression(engineer.tireSlipAngleIndicatedFR));
        progressTireSlipAngleIndicatedRL.progressProperty().bind(DoubleExpression.numberExpression(engineer.tireSlipAngleIndicatedRL));
        progressTireSlipAngleIndicatedRR.progressProperty().bind(DoubleExpression.numberExpression(engineer.tireSlipAngleIndicatedRR));

        progressWheelOnRumbleStripFL.progressProperty().bind(engineer.wheelOnRumbleStripFL);
        progressWheelOnRumbleStripFR.progressProperty().bind(engineer.wheelOnRumbleStripFR);
        progressWheelOnRumbleStripRL.progressProperty().bind(engineer.wheelOnRumbleStripRL);
        progressWheelOnRumbleStripRR.progressProperty().bind(engineer.wheelOnRumbleStripRR);

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

        labelCarGear.textProperty().bind(StringExpression.stringExpression(engineer.carGear));

        sliderTemperatureUnits.valueProperty().bindBidirectional(temperatureUnits);
        sliderTemperatureUnits.setBlockIncrement(1.0);
        sliderTemperatureUnits.setMinorTickCount(0);
        sliderTemperatureUnits.setMajorTickUnit(1.0);
        sliderTemperatureUnits.setSnapToTicks(true);

        if (temperatureUnits.getValue() == 0) {
            labelTireTempFL.textProperty().bind(Bindings.format("%5.1f", engineer.tireTempFL.subtract(32).divide(1.8)).concat("°C"));
            labelTireTempFR.textProperty().bind(Bindings.format("%5.1f", engineer.tireTempFR.subtract(32).divide(1.8)).concat("°C"));
            labelTireTempRL.textProperty().bind(Bindings.format("%5.1f", engineer.tireTempRL.subtract(32).divide(1.8)).concat("°C"));
            labelTireTempRR.textProperty().bind(Bindings.format("%5.1f", engineer.tireTempRR.subtract(32).divide(1.8)).concat("°C"));
        } else if (temperatureUnits.getValue() == 1) {
            labelTireTempFL.textProperty().bind(Bindings.format("%5.1f", engineer.tireTempFL).concat("°F"));
            labelTireTempFR.textProperty().bind(Bindings.format("%5.1f", engineer.tireTempFR).concat("°F"));
            labelTireTempRL.textProperty().bind(Bindings.format("%5.1f", engineer.tireTempRL).concat("°F"));
            labelTireTempRR.textProperty().bind(Bindings.format("%5.1f", engineer.tireTempRR).concat("°F"));
        }


        temperatureUnits.addListener((observable, oldValue, newValue) -> {
            if (temperatureUnits.getValue() == 0) {
                labelTireTempFL.textProperty().bind(Bindings.format("%5.1f", engineer.tireTempFL.subtract(32).divide(1.8)).concat("°C"));
                labelTireTempFR.textProperty().bind(Bindings.format("%5.1f", engineer.tireTempFR.subtract(32).divide(1.8)).concat("°C"));
                labelTireTempRL.textProperty().bind(Bindings.format("%5.1f", engineer.tireTempRL.subtract(32).divide(1.8)).concat("°C"));
                labelTireTempRR.textProperty().bind(Bindings.format("%5.1f", engineer.tireTempRR.subtract(32).divide(1.8)).concat("°C"));
            } else {
                labelTireTempFL.textProperty().bind(Bindings.format("%5.1f", engineer.tireTempFL).concat("°F"));
                labelTireTempFR.textProperty().bind(Bindings.format("%5.1f", engineer.tireTempFR).concat("°F"));
                labelTireTempRL.textProperty().bind(Bindings.format("%5.1f", engineer.tireTempRL).concat("°F"));
                labelTireTempRR.textProperty().bind(Bindings.format("%5.1f", engineer.tireTempRR).concat("°F"));
            }
        });

        labelCarSpeed.textProperty().bind(Bindings.format("%5.1f", engineer.carSpeed).concat(" m/s"));
        labelCarPower.textProperty().bind(Bindings.format("%5.0f", engineer.carPower.divide(1000)).concat(" kW"));
        labelCarTorque.textProperty().bind(Bindings.format("%5.0f", engineer.carTorque).concat(" Nm"));
        labelCarBoost.textProperty().bind(Bindings.format("%5.1f", engineer.carBoost).concat(" psi"));

        labelCarPositionX.textProperty().bind(Bindings.format("%5.2f", engineer.carPositionX));
        labelCarPositionY.textProperty().bind(Bindings.format("%5.2f", engineer.carPositionY));
        labelCarPositionZ.textProperty().bind(Bindings.format("%5.2f", engineer.carPositionZ));

        labelRaceDistanceTravelled.textProperty().bind(Bindings.format("%5.3f", engineer.raceDistanceTravelled.divide(1000)).concat(" km"));
        labelRaceFuel.textProperty().bind(Bindings.format("%5.2f", engineer.raceFuel.multiply(100)).concat("%"));
        progressRaceFuel.progressProperty().bind(engineer.raceFuel);
        labelRaceLapNumber.textProperty().bind(engineer.raceLapNumber.add(1).asString());

        engineer.raceCurrentLap.addListener(observable -> {
            labelRaceCurrentLap.textProperty().bind(getTimeString(engineer.raceCurrentLap.getValue()));
        });
        engineer.raceLastLap.addListener(observable -> {
            labelRaceLastLap.textProperty().bind(getTimeString(engineer.raceLastLap.getValue()));
        });
        engineer.raceBestLap.addListener(observable -> {
            labelRaceBestLap.textProperty().bind(getTimeString(engineer.raceBestLap.getValue()));
        });
        engineer.raceCurrentRaceTime.addListener(observable -> {
            labelRaceCurrentRaceTime.textProperty().bind(getTimeString(engineer.raceCurrentRaceTime.getValue()));
        });


        labelRacePosition.textProperty().bind(engineer.racePosition.asString());
        labelRaceNormalizedDrivingLine.textProperty().bind(engineer.raceNormalizedDrivingLine.asString());
        progressRaceNormalizedDrivingLine.progressProperty().bind(engineer.raceNormalizedDrivingLine.divide(255.0).add(0.5));
        labelRaceNormalizedAIBrakeDifference.textProperty().bind(engineer.raceNormalizedAIBrakeDifference.asString());
        progressRaceNormalizedAIBrakeDifference.progressProperty().bind(engineer.raceNormalizedAIBrakeDifference.divide(255.0).add(0.5));
        labelCarAccel.textProperty().bind(engineer.carAccel.asString());
        progressCarAccel.progressProperty().bind(engineer.carAccel.divide(255.0));
        labelCarBrake.textProperty().bind(engineer.carBrake.asString());
        progressCarBrake.progressProperty().bind(engineer.carBrake.divide(255.0));
        labelCarHandbrake.textProperty().bind(engineer.carHandBrake.asString());
        progressCarHandbrake.progressProperty().bind(engineer.carHandBrake.divide(255.0));
        labelCarClutch.textProperty().bind(engineer.carClutch.asString());
        progressCarClutch.progressProperty().bind(engineer.carClutch.divide(255.0));
        labelCarSteer.textProperty().bind(engineer.carSteer.asString());
        progressCarSteer.progressProperty().bind(engineer.carSteer.divide(255.0).add(0.5));

        try {
            spAddressLocalIP.setValue(Inet4Address.getLocalHost().getHostAddress());
        } catch (Exception e) {
            System.out.println("Error reading local IP: " + e.toString());
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

            } else {
                tmpStage.setMaximized(false);
                buttonResize.setText("Maximize Window");
                maximized.setValue(false);
            }
            horizontalScale.setValue(buttonResizeDrag.getScene().getWindow().getWidth() / INITIAL_HSCALE);
            verticalScale.setValue(buttonResizeDrag.getScene().getWindow().getHeight() / INITIAL_VSCALE);
            scaledFontSize = Math.min(verticalScale.getValue(), horizontalScale.getValue()) * INITIAL_FONTSIZE;
            resizeFont();
            rescale();

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
            scaledFontSize = Math.min(verticalScale.getValue(), horizontalScale.getValue()) * INITIAL_FONTSIZE;
            resizeFont();
            rescale();

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
        rescale();
    }

    private void rescale() {
        progressTireSlipRatioFL.setPrefWidth(progressTireSlipRatioFL.getMinWidth() * verticalScale.getValue());
        progressTireSlipRatioFL.setPrefHeight(progressTireSlipRatioFL.getMinHeight() * horizontalScale.getValue());
        progressTireSlipRatioFR.setPrefWidth(progressTireSlipRatioFR.getMinWidth() * verticalScale.getValue());
        progressTireSlipRatioFR.setPrefHeight(progressTireSlipRatioFR.getMinHeight() * horizontalScale.getValue());
        progressTireSlipRatioRL.setPrefWidth(progressTireSlipRatioRL.getMinWidth() * verticalScale.getValue());
        progressTireSlipRatioRL.setPrefHeight(progressTireSlipRatioRL.getMinHeight() * horizontalScale.getValue());
        progressTireSlipRatioRR.setPrefWidth(progressTireSlipRatioRR.getMinWidth() * verticalScale.getValue());
        progressTireSlipRatioRR.setPrefHeight(progressTireSlipRatioRR.getMinHeight() * horizontalScale.getValue());

        progressTireSlipAngleFL.setPrefWidth(progressTireSlipAngleFL.getMinWidth() * verticalScale.getValue());
        progressTireSlipAngleFL.setPrefHeight(progressTireSlipAngleFL.getMinHeight() * horizontalScale.getValue());
        progressTireSlipAngleFR.setPrefWidth(progressTireSlipAngleFR.getMinWidth() * verticalScale.getValue());
        progressTireSlipAngleFR.setPrefHeight(progressTireSlipAngleFR.getMinHeight() * horizontalScale.getValue());
        progressTireSlipAngleRL.setPrefWidth(progressTireSlipAngleRL.getMinWidth() * verticalScale.getValue());
        progressTireSlipAngleRL.setPrefHeight(progressTireSlipAngleRL.getMinHeight() * horizontalScale.getValue());
        progressTireSlipAngleRR.setPrefWidth(progressTireSlipAngleRR.getMinWidth() * verticalScale.getValue());
        progressTireSlipAngleRR.setPrefHeight(progressTireSlipAngleRR.getMinHeight() * horizontalScale.getValue());

        progressTireSlipIndicatedFL.setPrefWidth(progressTireSlipIndicatedFL.getMinWidth() * horizontalScale.getValue());
        progressTireSlipIndicatedFL.setPrefHeight(progressTireSlipIndicatedFL.getMinHeight() * verticalScale.getValue());
        progressTireSlipIndicatedFR.setPrefWidth(progressTireSlipIndicatedFR.getMinWidth() * horizontalScale.getValue());
        progressTireSlipIndicatedFR.setPrefHeight(progressTireSlipIndicatedFR.getMinHeight() * verticalScale.getValue());
        progressTireSlipIndicatedRL.setPrefWidth(progressTireSlipIndicatedRL.getMinWidth() * horizontalScale.getValue());
        progressTireSlipIndicatedRL.setPrefHeight(progressTireSlipIndicatedRL.getMinHeight() * verticalScale.getValue());
        progressTireSlipIndicatedRR.setPrefWidth(progressTireSlipIndicatedRR.getMinWidth() * horizontalScale.getValue());
        progressTireSlipIndicatedRR.setPrefHeight(progressTireSlipIndicatedRR.getMinHeight() * verticalScale.getValue());

        progressTireSlipAngleIndicatedFL.setPrefWidth(progressTireSlipAngleIndicatedFL.getMinWidth() * horizontalScale.getValue());
        progressTireSlipAngleIndicatedFL.setPrefHeight(progressTireSlipAngleIndicatedFL.getMinHeight() * verticalScale.getValue());
        progressTireSlipAngleIndicatedFR.setPrefWidth(progressTireSlipAngleIndicatedFR.getMinWidth() * horizontalScale.getValue());
        progressTireSlipAngleIndicatedFR.setPrefHeight(progressTireSlipAngleIndicatedFR.getMinHeight() * verticalScale.getValue());
        progressTireSlipAngleIndicatedRL.setPrefWidth(progressTireSlipAngleIndicatedRL.getMinWidth() * horizontalScale.getValue());
        progressTireSlipAngleIndicatedRL.setPrefHeight(progressTireSlipAngleIndicatedRL.getMinHeight() * verticalScale.getValue());
        progressTireSlipAngleIndicatedRR.setPrefWidth(progressTireSlipAngleIndicatedRR.getMinWidth() * horizontalScale.getValue());
        progressTireSlipAngleIndicatedRR.setPrefHeight(progressTireSlipAngleIndicatedRR.getMinHeight() * verticalScale.getValue());

        progressSuspensionTravelFL.setPrefWidth(progressSuspensionTravelFL.getMinWidth() * verticalScale.getValue());
        progressSuspensionTravelFL.setPrefHeight(progressSuspensionTravelFL.getMinHeight() * horizontalScale.getValue());
        progressSuspensionTravelFR.setPrefWidth(progressSuspensionTravelFR.getMinWidth() * verticalScale.getValue());
        progressSuspensionTravelFR.setPrefHeight(progressSuspensionTravelFR.getMinHeight() * horizontalScale.getValue());
        progressSuspensionTravelRL.setPrefWidth(progressSuspensionTravelRL.getMinWidth() * verticalScale.getValue());
        progressSuspensionTravelRL.setPrefHeight(progressSuspensionTravelRL.getMinHeight() * horizontalScale.getValue());
        progressSuspensionTravelRR.setPrefWidth(progressSuspensionTravelRR.getMinWidth() * verticalScale.getValue());
        progressSuspensionTravelRR.setPrefHeight(progressSuspensionTravelRR.getMinHeight() * horizontalScale.getValue());

        progressWheelInPuddleDepthFL.setPrefWidth(progressWheelInPuddleDepthFL.getMinWidth() * verticalScale.getValue());
        progressWheelInPuddleDepthFL.setPrefHeight(progressWheelInPuddleDepthFL.getMinHeight() * horizontalScale.getValue());
        progressWheelInPuddleDepthFR.setPrefWidth(progressWheelInPuddleDepthFR.getMinWidth() * verticalScale.getValue());
        progressWheelInPuddleDepthFR.setPrefHeight(progressWheelInPuddleDepthFR.getMinHeight() * horizontalScale.getValue());
        progressWheelInPuddleDepthRL.setPrefWidth(progressWheelInPuddleDepthRL.getMinWidth() * verticalScale.getValue());
        progressWheelInPuddleDepthRL.setPrefHeight(progressWheelInPuddleDepthRL.getMinHeight() * horizontalScale.getValue());
        progressWheelInPuddleDepthRR.setPrefWidth(progressWheelInPuddleDepthRR.getMinWidth() * verticalScale.getValue());
        progressWheelInPuddleDepthRR.setPrefHeight(progressWheelInPuddleDepthRR.getMinHeight() * horizontalScale.getValue());

        progressSurfaceRumbleFL.setPrefWidth(progressSurfaceRumbleFL.getMinWidth() * horizontalScale.getValue());
        progressSurfaceRumbleFL.setPrefHeight(progressSurfaceRumbleFL.getMinHeight() * verticalScale.getValue());
        progressSurfaceRumbleFR.setPrefWidth(progressSurfaceRumbleFR.getMinWidth() * horizontalScale.getValue());
        progressSurfaceRumbleFR.setPrefHeight(progressSurfaceRumbleFR.getMinHeight() * verticalScale.getValue());
        progressSurfaceRumbleRL.setPrefWidth(progressSurfaceRumbleRL.getMinWidth() * horizontalScale.getValue());
        progressSurfaceRumbleRL.setPrefHeight(progressSurfaceRumbleRL.getMinHeight() * verticalScale.getValue());
        progressSurfaceRumbleRR.setPrefWidth(progressSurfaceRumbleRR.getMinWidth() * horizontalScale.getValue());
        progressSurfaceRumbleRR.setPrefHeight(progressSurfaceRumbleRR.getMinHeight() * verticalScale.getValue());

        progressWheelOnRumbleStripFL.setPrefWidth(progressWheelOnRumbleStripFL.getMinWidth() * horizontalScale.getValue());
        progressWheelOnRumbleStripFL.setPrefHeight(progressWheelOnRumbleStripFL.getMinHeight() * verticalScale.getValue());
        progressWheelOnRumbleStripFR.setPrefWidth(progressWheelOnRumbleStripFR.getMinWidth() * horizontalScale.getValue());
        progressWheelOnRumbleStripFR.setPrefHeight(progressWheelOnRumbleStripFR.getMinHeight() * verticalScale.getValue());
        progressWheelOnRumbleStripRL.setPrefWidth(progressWheelOnRumbleStripRL.getMinWidth() * horizontalScale.getValue());
        progressWheelOnRumbleStripRL.setPrefHeight(progressWheelOnRumbleStripRL.getMinHeight() * verticalScale.getValue());
        progressWheelOnRumbleStripRR.setPrefWidth(progressWheelOnRumbleStripRR.getMinWidth() * horizontalScale.getValue());
        progressWheelOnRumbleStripRR.setPrefHeight(progressWheelOnRumbleStripRR.getMinHeight() * verticalScale.getValue());

        sliderShiftIndicatorThresholdLow.setPrefWidth(sliderShiftIndicatorThresholdLow.getMinWidth() * horizontalScale.getValue());
        sliderShiftIndicatorThresholdHigh.setPrefWidth(sliderShiftIndicatorThresholdHigh.getMinWidth() * horizontalScale.getValue());
        sliderTemperatureUnits.setPrefWidth(sliderTemperatureUnits.getMinWidth() * horizontalScale.getValue());


        progressAccelerationCurrent.setPrefWidth(progressAccelerationCurrent.getMinWidth() * horizontalScale.getValue());
        progressAccelerationCurrent.setPrefHeight(progressAccelerationCurrent.getMinHeight() * verticalScale.getValue());
        progressDecelerationCurrent.setPrefWidth(progressDecelerationCurrent.getMinWidth() * horizontalScale.getValue());
        progressDecelerationCurrent.setPrefHeight(progressDecelerationCurrent.getMinHeight() * verticalScale.getValue());

        progressRaceFuel.setPrefWidth(progressRaceFuel.getMinWidth() * verticalScale.getValue());
        progressRaceFuel.setPrefHeight(progressRaceFuel.getMinHeight() * horizontalScale.getValue());

        progressRaceNormalizedDrivingLine.setPrefWidth(progressRaceNormalizedDrivingLine.getMinWidth() * horizontalScale.getValue());
        progressRaceNormalizedDrivingLine.setPrefHeight(progressRaceNormalizedDrivingLine.getMinHeight() * verticalScale.getValue());
        progressRaceNormalizedAIBrakeDifference.setPrefWidth(progressRaceNormalizedAIBrakeDifference.getMinWidth() * horizontalScale.getValue());
        progressRaceNormalizedAIBrakeDifference.setPrefHeight(progressRaceNormalizedAIBrakeDifference.getMinHeight() * verticalScale.getValue());
        progressCarAccel.setPrefWidth(progressCarAccel.getMinWidth() * horizontalScale.getValue());
        progressCarAccel.setPrefHeight(progressCarAccel.getMinHeight() * verticalScale.getValue());
        progressCarBrake.setPrefWidth(progressCarBrake.getMinWidth() * horizontalScale.getValue());
        progressCarBrake.setPrefHeight(progressCarBrake.getMinHeight() * verticalScale.getValue());
        progressCarHandbrake.setPrefWidth(progressCarHandbrake.getMinWidth() * horizontalScale.getValue());
        progressCarHandbrake.setPrefHeight(progressCarHandbrake.getMinHeight() * verticalScale.getValue());
        progressCarClutch.setPrefWidth(progressCarClutch.getMinWidth() * horizontalScale.getValue());
        progressCarClutch.setPrefHeight(progressCarClutch.getMinHeight() * verticalScale.getValue());
        progressCarSteer.setPrefWidth(progressCarSteer.getMinWidth() * horizontalScale.getValue());
        progressCarSteer.setPrefHeight(progressCarSteer.getMinHeight() * verticalScale.getValue());


    }

    private void resizeFont() {
        for (Node n : tpDetailInfo.lookupAll(".label")) {
            n.setStyle("-fx-font-size: " + scaledFontSize + "px;");
        }
        for (Node n : borderPaneRoot.lookupAll(".button")) {
            n.setStyle("-fx-font-size: " + scaledFontSize + "px;");
        }
        for (Node n : tpDetailInfo.lookupAll(".tab-label")) {
            n.setStyle("-fx-font-size: " + scaledFontSize + "px;");
        }
        tpDetailInfo.setTabMaxHeight(verticalScale.getValue() * 20);
        tpDetailInfo.setTabMaxWidth(horizontalScale.getValue() * 200);


    }

    private StringExpression getTimeString(double input) {
        int hours = (int) input / 3600;
        int minutes = (int) (input / 60) % 60;
        int seconds = (int) input % 60;
        int milliseconds = (int) (input * 1000) % 1000;

        return StringFormatter.format("%02d:%02d:%02d.%03d", hours, minutes, seconds, milliseconds);
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
