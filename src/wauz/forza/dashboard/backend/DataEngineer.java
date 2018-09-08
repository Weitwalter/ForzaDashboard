package wauz.forza.dashboard.backend;

import javafx.beans.property.*;

public class DataEngineer {
    private static DataEngineer instance;

    //Basic FM7 data out Values

    // 1 or 0 = in Menus. Race starts when you get control of the car
    public final IntegerProperty isRaceOn = new SimpleIntegerProperty();
    //should be uInt32, Time in Game, not in Race
    public final LongProperty timestamp = new SimpleLongProperty();
    //Unique ID of the car make/model
    public final IntegerProperty carOrdinal = new SimpleIntegerProperty();
    //Between 0 (E -- worst cars) and 8 (X class -- best cars) inclusive
    public final IntegerProperty carClass = new SimpleIntegerProperty();
    //Between 100 (slowest car) and 999 (fastest car) inclusive
    public final IntegerProperty carPerformanceIndex = new SimpleIntegerProperty();
    //Corresponds to EDrivetrainType; 0 = FWD, 1 = RWD, 2 = AWD
    public final IntegerProperty drivetrainType = new SimpleIntegerProperty();
    //Number of cylinders in the engine
    public final IntegerProperty numOfCylinders = new SimpleIntegerProperty();

    //Engine RPMs (can be fractional values)
    public final DoubleProperty rpmCurrent = new SimpleDoubleProperty();
    public final DoubleProperty rpmMax = new SimpleDoubleProperty();
    public final DoubleProperty rpmIdle = new SimpleDoubleProperty();

    //acceleration Values in the car's local space; X = right, Y = up, Z = forward
    public final DoubleProperty accelerationX = new SimpleDoubleProperty();
    public final DoubleProperty accelerationY = new SimpleDoubleProperty();
    public final DoubleProperty accelerationZ = new SimpleDoubleProperty();

    //Speed Values in the car's local space; X = right, Y = up, Z = forward
    public final DoubleProperty velocityX = new SimpleDoubleProperty();
    public final DoubleProperty velocityY = new SimpleDoubleProperty();
    public final DoubleProperty velocityZ = new SimpleDoubleProperty();

    //Speed Values in the car's local space; X = pitch, Y = yaw, Z = roll
    public final DoubleProperty angularVelocityX = new SimpleDoubleProperty();
    public final DoubleProperty angularVelocityY = new SimpleDoubleProperty();
    public final DoubleProperty angularVelocityZ = new SimpleDoubleProperty();

    public final DoubleProperty movementYaw = new SimpleDoubleProperty();
    public final DoubleProperty movementPitch = new SimpleDoubleProperty();
    public final DoubleProperty movementRoll = new SimpleDoubleProperty();

    //suspension travel for each wheel normalized: 0.0f = max stretch; 1.0 = max compression
    public final DoubleProperty suspensionTravelNormalizedFL = new SimpleDoubleProperty();
    public final DoubleProperty suspensionTravelNormalizedFR = new SimpleDoubleProperty();
    public final DoubleProperty suspensionTravelNormalizedRL = new SimpleDoubleProperty();
    public final DoubleProperty suspensionTravelNormalizedRR = new SimpleDoubleProperty();

    // Actual suspension travel in meters
    public final DoubleProperty suspensionTravelMetersFL = new SimpleDoubleProperty();
    public final DoubleProperty suspensionTravelMetersFR = new SimpleDoubleProperty();
    public final DoubleProperty suspensionTravelMetersRL = new SimpleDoubleProperty();
    public final DoubleProperty suspensionTravelMetersRR = new SimpleDoubleProperty();

    //Wheel rotation speed radians/sec.
    public final DoubleProperty wheelRotationSpeedFL = new SimpleDoubleProperty();
    public final DoubleProperty wheelRotationSpeedFR = new SimpleDoubleProperty();
    public final DoubleProperty wheelRotationSpeedRL = new SimpleDoubleProperty();
    public final DoubleProperty wheelRotationSpeedRR = new SimpleDoubleProperty();

    // Tire normalized slip ratio, = 0 means 100% grip and |ratio| > 1.0 means loss of grip.
    public final DoubleProperty tireSlipRatioNormalizedFL = new SimpleDoubleProperty();
    public final DoubleProperty tireSlipRatioNormalizedFR = new SimpleDoubleProperty();
    public final DoubleProperty tireSlipRatioNormalizedRL = new SimpleDoubleProperty();
    public final DoubleProperty tireSlipRatioNormalizedRR = new SimpleDoubleProperty();

    // Tire normalized slip angle, = 0 means 100% grip and |angle| > 1.0 means loss of grip.
    //?? makes little sense
    public final DoubleProperty tireSlipAngleNormalizedFL = new SimpleDoubleProperty();
    public final DoubleProperty tireSlipAngleNormalizedFR = new SimpleDoubleProperty();
    public final DoubleProperty tireSlipAngleNormalizedRL = new SimpleDoubleProperty();
    public final DoubleProperty tireSlipAngleNormalizedRR = new SimpleDoubleProperty();

    // Tire normalized combined slip, = 0 means 100% grip and |slip| > 1.0 means loss of grip.
    public final DoubleProperty tireSlipCombinedNormalizedFL = new SimpleDoubleProperty();
    public final DoubleProperty tireSlipCombinedNormalizedFR = new SimpleDoubleProperty();
    public final DoubleProperty tireSlipCombinedNormalizedRL = new SimpleDoubleProperty();
    public final DoubleProperty tireSlipCombinedNormalizedRR = new SimpleDoubleProperty();

    // wheels rolling on rumble strips 1 when wheel is on rumble strip, = 0 when off.
    public final IntegerProperty wheelOnRumbleStripFL = new SimpleIntegerProperty();
    public final IntegerProperty wheelOnRumbleStripFR = new SimpleIntegerProperty();
    public final IntegerProperty wheelOnRumbleStripRL = new SimpleIntegerProperty();
    public final IntegerProperty wheelOnRumbleStripRR = new SimpleIntegerProperty();

    // Non-dimensional surface rumble values passed to controller force feedback
    public final DoubleProperty surfaceRumbleFL = new SimpleDoubleProperty();
    public final DoubleProperty surfaceRumbleFR = new SimpleDoubleProperty();
    public final DoubleProperty surfaceRumbleRL = new SimpleDoubleProperty();
    public final DoubleProperty surfaceRumbleRR = new SimpleDoubleProperty();

    // Wheels in water puddles from 0 to 1, where 1 is the deepest puddle
    public final DoubleProperty wheelInPuddleDepthFL = new SimpleDoubleProperty();
    public final DoubleProperty wheelInPuddleDepthFR = new SimpleDoubleProperty();
    public final DoubleProperty wheelInPuddleDepthRL = new SimpleDoubleProperty();
    public final DoubleProperty wheelInPuddleDepthRR = new SimpleDoubleProperty();


    //Calculated Values to enrich display possibilities
    // this is reset to 0 each time your carOrdinal (=car) changes.
    public final DoubleProperty rpmMaxMeasured = new SimpleDoubleProperty();

    public final StringProperty drivetrainTypeString= new SimpleStringProperty();
    public final StringProperty carClassString= new SimpleStringProperty();

    public final DoubleProperty velocityTrue = new SimpleDoubleProperty();
    public final DoubleProperty velocityTrueKph = new SimpleDoubleProperty();
    public final DoubleProperty velocityTrueMph = new SimpleDoubleProperty();

    public final DoubleProperty angularVelocityTrue = new SimpleDoubleProperty();

    public final DoubleProperty normalizedAccelerationTrue = new SimpleDoubleProperty();
    public final DoubleProperty normalizedDecelerationTrue = new SimpleDoubleProperty();
    public final DoubleProperty accelerationMaxMeasured = new SimpleDoubleProperty();
    public final DoubleProperty decelerationMaxMeasured = new SimpleDoubleProperty();


    public final DoubleProperty wheelRpmDiffFrontPercentage = new SimpleDoubleProperty();
    public final DoubleProperty wheelRpmDiffFrontAbsolute = new SimpleDoubleProperty();
    public final DoubleProperty wheelRpmDiffRearPercentage = new SimpleDoubleProperty();
    public final DoubleProperty wheelRpmDiffRearAbsolute = new SimpleDoubleProperty();
    public final DoubleProperty wheelRpmDiffLeftPercentage = new SimpleDoubleProperty();
    public final DoubleProperty wheelRpmDiffLeftAbsolute = new SimpleDoubleProperty();
    public final DoubleProperty wheelRpmDiffRightPercentage = new SimpleDoubleProperty();
    public final DoubleProperty wheelRpmDiffRightAbsolute = new SimpleDoubleProperty();

    public final DoubleProperty shiftWarning = new SimpleDoubleProperty();

    public final DoubleProperty shiftWarningThresholdLow = new SimpleDoubleProperty();
    public final DoubleProperty shiftWarningThresholdHigh = new SimpleDoubleProperty();

    public final StringProperty carDescription = new SimpleStringProperty();

    public final DoubleProperty surfaceRumbleMax = new SimpleDoubleProperty();


    //public final DoubleProperty calculatedProperty = new SimpleDoubleProperty();
    //add listener to carOrdinal to reset this
    //add listener to rpmCurrent to update this (if greater than prev)

    private DataEngineer() {
        //calculatedProperty.bind(rpmCurrent.divide(rpmMax));
        isRaceOn.addListener((observable, oldValue, newValue) -> System.out.println("isRaceOn:" + newValue));
        //timestamp.addListener((observable, oldValue, newValue) -> System.out.println("timestamp:" + newValue));
        //rpmMax.addListener((observable, oldValue, newValue) -> System.out.println("rpmMax:" + newValue));
        //rpmCurrent.addListener((observable, oldValue, newValue) -> System.out.println("rpmCurrent:" + newValue));
        carOrdinal.addListener((observable, oldValue, newValue) -> {
            this.rpmMaxMeasured.setValue(0);
            this.accelerationMaxMeasured.setValue(10);
            this.decelerationMaxMeasured.setValue(-10);

        });
        shiftWarningThresholdLow.addListener((observable, oldValue, newValue) -> {
            if (shiftWarningThresholdLow.getValue()>shiftWarningThresholdHigh.getValue()){
                shiftWarningThresholdHigh.setValue(shiftWarningThresholdLow.getValue()+1);
            }
        });
        surfaceRumbleFL.addListener((observable, oldValue, newValue) -> {
            if (surfaceRumbleFL.getValue()>surfaceRumbleMax.getValue()){
                surfaceRumbleMax.setValue(newValue);
            }
        });
        surfaceRumbleFR.addListener((observable, oldValue, newValue) -> {
            if (surfaceRumbleFR.getValue()>surfaceRumbleMax.getValue()){
                surfaceRumbleMax.setValue(newValue);
            }
        });
        surfaceRumbleRL.addListener((observable, oldValue, newValue) -> {
            if (surfaceRumbleRL.getValue()>surfaceRumbleMax.getValue()){
                surfaceRumbleMax.setValue(newValue);
            }
        });
        surfaceRumbleRR.addListener((observable, oldValue, newValue) -> {
            if (surfaceRumbleRR.getValue()>surfaceRumbleMax.getValue()){
                surfaceRumbleMax.setValue(newValue);
            }
        });


    }

    public static DataEngineer getInstance() {
        if (instance == null) {
            instance = new DataEngineer();
        }
        return instance;
    }
}
