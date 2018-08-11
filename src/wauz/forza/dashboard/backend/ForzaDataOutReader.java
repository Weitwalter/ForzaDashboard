package wauz.forza.dashboard.backend;

import javafx.application.Platform;
import javafx.beans.property.DoubleProperty;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.Properties;

public class ForzaDataOutReader {
    private final DataEngineer engineer;
    private boolean stopProcessing = false;
    protected Properties propConfig;

    public void stopProcessing() {
        this.stopProcessing = true;
    }

    public ForzaDataOutReader(Properties inputConfig) {

        this.engineer = DataEngineer.getInstance();
        this.propConfig = inputConfig;
        engineer.shiftWarningThresholdLow.setValue(Double.parseDouble(propConfig.getProperty("shiftIndicatorLowThresholdDefault")));
        engineer.shiftWarningThresholdHigh.setValue(Double.parseDouble(propConfig.getProperty("shiftIndicatorHighThresholdDefault")));
    }

    public void startListener(int port) {
        new Thread() {
            @Override
            public void run() {
                super.run();
                try {

                    // Create a socket to listen on the port.

                    DatagramSocket dsocket = new DatagramSocket(port);
                    //Excess Bytes will be discarded
                    byte[] buffer = new byte[500];
                    // dsocket.setSoTimeout(1000);
                    // Create a packet to receive data into the buffer
                    DatagramPacket packet = new DatagramPacket(buffer, buffer.length);

                    while (!stopProcessing) {
                        // Wait to receive a datagram
                        dsocket.receive(packet);
                            final byte[] thisBuffer = packet.getData();
                            Platform.runLater(() -> {
                                try {
                                    engineer.isRaceOn.setValue(getBytes(thisBuffer, 0, 4).getInt());
                                    engineer.timestamp.setValue(getBytes(thisBuffer, 4, 8).getInt()); //technically unsigned. irrelevant as long as value is below Integer.MAX_VALUE

                                    if (engineer.isRaceOn.getValue() == 1) {

                                        engineer.rpmMax.setValue(getBytes(thisBuffer, 8, 12).getFloat());
                                        engineer.rpmIdle.setValue(getBytes(thisBuffer, 12, 16).getFloat());
                                        engineer.rpmCurrent.setValue(getBytes(thisBuffer, 16, 20).getFloat());

                                        engineer.accelerationX.setValue(getBytes(thisBuffer, 20, 24).getFloat());
                                        engineer.accelerationY.setValue(getBytes(thisBuffer, 24, 28).getFloat());
                                        engineer.accelerationZ.setValue(getBytes(thisBuffer, 28, 32).getFloat());

                                        engineer.velocityX.setValue(getBytes(thisBuffer, 32, 36).getFloat());
                                        engineer.velocityY.setValue(getBytes(thisBuffer, 36, 40).getFloat());
                                        engineer.velocityZ.setValue(getBytes(thisBuffer, 40, 44).getFloat());

                                        engineer.angularVelocityX.setValue(getBytes(thisBuffer, 44, 48).getFloat());
                                        engineer.angularVelocityY.setValue(getBytes(thisBuffer, 48, 52).getFloat());
                                        engineer.angularVelocityZ.setValue(getBytes(thisBuffer, 52, 56).getFloat());

                                        engineer.movementYaw.setValue(getBytes(thisBuffer, 56, 60).getFloat());
                                        engineer.movementPitch.setValue(getBytes(thisBuffer, 60, 64).getFloat());
                                        engineer.movementRoll.setValue(getBytes(thisBuffer, 64, 68).getFloat());

                                        engineer.suspensionTravelNormalizedFL.setValue(getBytes(thisBuffer, 68, 72).getFloat());
                                        engineer.suspensionTravelNormalizedFR.setValue(getBytes(thisBuffer, 72, 76).getFloat());
                                        engineer.suspensionTravelNormalizedRL.setValue(getBytes(thisBuffer, 76, 80).getFloat());
                                        engineer.suspensionTravelNormalizedRR.setValue(getBytes(thisBuffer, 80, 84).getFloat());

                                        engineer.tireSlipRatioNormalizedFL.setValue(getBytes(thisBuffer, 84, 88).getFloat());
                                        engineer.tireSlipRatioNormalizedFR.setValue(getBytes(thisBuffer, 88, 92).getFloat());
                                        engineer.tireSlipRatioNormalizedRL.setValue(getBytes(thisBuffer, 92, 96).getFloat());
                                        engineer.tireSlipRatioNormalizedRR.setValue(getBytes(thisBuffer, 96, 100).getFloat());

                                        engineer.wheelRotationSpeedFL.setValue(getBytes(thisBuffer, 100, 104).getFloat());
                                        engineer.wheelRotationSpeedFR.setValue(getBytes(thisBuffer, 104, 108).getFloat());
                                        engineer.wheelRotationSpeedRL.setValue(getBytes(thisBuffer, 108, 112).getFloat());
                                        engineer.wheelRotationSpeedRR.setValue(getBytes(thisBuffer, 112, 116).getFloat());

                                        engineer.wheelOnRumbleStripFL.setValue(getBytes(thisBuffer, 116, 120).getInt());
                                        engineer.wheelOnRumbleStripFR.setValue(getBytes(thisBuffer, 120, 124).getInt());
                                        engineer.wheelOnRumbleStripRL.setValue(getBytes(thisBuffer, 124, 128).getInt());
                                        engineer.wheelOnRumbleStripRR.setValue(getBytes(thisBuffer, 128, 132).getInt());

                                        engineer.wheelInPuddleDepthFL.setValue(getBytes(thisBuffer, 132, 136).getFloat());
                                        engineer.wheelInPuddleDepthFR.setValue(getBytes(thisBuffer, 136, 140).getFloat());
                                        engineer.wheelInPuddleDepthRL.setValue(getBytes(thisBuffer, 140, 144).getFloat());
                                        engineer.wheelInPuddleDepthRR.setValue(getBytes(thisBuffer, 144, 148).getFloat());

                                        engineer.surfaceRumbleFL.setValue(getBytes(thisBuffer, 148, 152).getFloat());
                                        engineer.surfaceRumbleFR.setValue(getBytes(thisBuffer, 152, 156).getFloat());
                                        engineer.surfaceRumbleRL.setValue(getBytes(thisBuffer, 156, 160).getFloat());
                                        engineer.surfaceRumbleRR.setValue(getBytes(thisBuffer, 160, 164).getFloat());

                                        engineer.tireSlipAngleNormalizedFL.setValue(getBytes(thisBuffer, 164, 168).getFloat());
                                        engineer.tireSlipAngleNormalizedFR.setValue(getBytes(thisBuffer, 168, 172).getFloat());
                                        engineer.tireSlipAngleNormalizedRL.setValue(getBytes(thisBuffer, 172, 176).getFloat());
                                        engineer.tireSlipAngleNormalizedRR.setValue(getBytes(thisBuffer, 176, 180).getFloat());

                                        engineer.tireSlipCombinedNormalizedFL.setValue(getBytes(thisBuffer, 180, 184).getFloat());
                                        engineer.tireSlipCombinedNormalizedFR.setValue(getBytes(thisBuffer, 184, 188).getFloat());
                                        engineer.tireSlipCombinedNormalizedRL.setValue(getBytes(thisBuffer, 188, 192).getFloat());
                                        engineer.tireSlipCombinedNormalizedRR.setValue(getBytes(thisBuffer, 192, 196).getFloat());

                                        engineer.suspensionTravelMetersFL.setValue(getBytes(thisBuffer, 196, 200).getFloat());
                                        engineer.suspensionTravelMetersFR.setValue(getBytes(thisBuffer, 200, 204).getFloat());
                                        engineer.suspensionTravelMetersRL.setValue(getBytes(thisBuffer, 204, 208).getFloat());
                                        engineer.suspensionTravelMetersRR.setValue(getBytes(thisBuffer, 208, 212).getFloat());

                                        engineer.carOrdinal.setValue(getBytes(thisBuffer, 212, 216).getInt());
                                        engineer.carClass.setValue(getBytes(thisBuffer, 216, 220).getInt());
                                        engineer.carPerformanceIndex.setValue(getBytes(thisBuffer, 220, 224).getInt());
                                        engineer.drivetrainType.setValue(getBytes(thisBuffer, 224, 228).getInt());
                                        engineer.numOfCylinders.setValue(getBytes(thisBuffer, 228, 232).getInt());

                                        //calculated
                                        engineer.rpmMaxMeasured.setValue(Math.max(engineer.rpmMaxMeasured.getValue(), engineer.rpmCurrent.getValue()));
                                        engineer.accelerationMaxMeasured.setValue(Math.max(engineer.accelerationMaxMeasured.getValue(), engineer.accelerationZ.getValue()));
                                        engineer.decelerationMaxMeasured.setValue(Math.min(engineer.decelerationMaxMeasured.getValue(), engineer.accelerationZ.getValue()));


                                        //calculate true speed
                                        engineer.velocityTrue.setValue(getVector(engineer.velocityX.getValue(), engineer.velocityY.getValue(), engineer.velocityZ.getValue()));
                                        engineer.velocityTrueKph.setValue(engineer.velocityTrue.getValue() * 3.6);
                                        engineer.velocityTrueMph.setValue(engineer.velocityTrue.getValue() * 2.23694);

                                        if (engineer.accelerationZ.getValue() < 0) {
                                            engineer.normalizedDecelerationTrue.setValue(engineer.accelerationZ.getValue() / engineer.decelerationMaxMeasured.getValue());
                                            engineer.normalizedAccelerationTrue.setValue(0.0);
                                        } else {
                                            engineer.normalizedDecelerationTrue.setValue(0.0);
                                            engineer.normalizedAccelerationTrue.setValue(engineer.accelerationZ.getValue() / engineer.accelerationMaxMeasured.getValue());

                                        }

                                        engineer.wheelRpmDiffFrontAbsolute.setValue((engineer.wheelRotationSpeedFR.getValue() - engineer.wheelRotationSpeedFL.getValue()) * 9.5493);
                                        if (engineer.wheelRotationSpeedFL.getValue() == 0.0)
                                            engineer.wheelRotationSpeedFL.setValue(0.00001);
                                        engineer.wheelRpmDiffFrontPercentage.setValue((engineer.wheelRotationSpeedFR.getValue() / engineer.wheelRotationSpeedFL.getValue() - 1) * 100);

                                        engineer.wheelRpmDiffRearAbsolute.setValue((engineer.wheelRotationSpeedRR.getValue() - engineer.wheelRotationSpeedRL.getValue()) * 9.5493);
                                        if (engineer.wheelRotationSpeedRL.getValue() == 0.0)
                                            engineer.wheelRotationSpeedRL.setValue(0.00001);
                                        engineer.wheelRpmDiffRearPercentage.setValue((engineer.wheelRotationSpeedRR.getValue() / engineer.wheelRotationSpeedRL.getValue() - 1) * 100);

                                        engineer.wheelRpmDiffLeftAbsolute.setValue((engineer.wheelRotationSpeedRL.getValue() - engineer.wheelRotationSpeedFL.getValue()) * 9.5493);
                                        engineer.wheelRpmDiffLeftPercentage.setValue((engineer.wheelRotationSpeedRL.getValue() / engineer.wheelRotationSpeedFL.getValue() - 1) * 100);

                                        engineer.wheelRpmDiffRightAbsolute.setValue((engineer.wheelRotationSpeedRR.getValue() - engineer.wheelRotationSpeedFR.getValue()) * 9.5493);
                                        if (engineer.wheelRotationSpeedFR.getValue() == 0.0)
                                            engineer.wheelRotationSpeedFR.setValue(0.00001);
                                        engineer.wheelRpmDiffLeftPercentage.setValue((engineer.wheelRotationSpeedRR.getValue() / engineer.wheelRotationSpeedFR.getValue() - 1) * 100);

                                        //true angular Velocity
                                        engineer.angularVelocityTrue.setValue(getVector(engineer.angularVelocityX.getValue(), engineer.angularVelocityY.getValue(), engineer.angularVelocityZ.getValue()));


                                        //calculate shift indicator
                                        if (engineer.rpmCurrent.getValue() > (engineer.rpmMaxMeasured.getValue() * engineer.shiftWarningThresholdLow.getValue() * 0.01)) {
                                            engineer.shiftWarning.setValue((engineer.rpmCurrent.getValue() - (engineer.rpmMaxMeasured.getValue() * engineer.shiftWarningThresholdLow.getValue() * 0.01)) / (engineer.rpmMaxMeasured.getValue() * engineer.shiftWarningThresholdHigh.getValue() * 0.01 - (engineer.rpmMaxMeasured.getValue() * engineer.shiftWarningThresholdLow.getValue() * 0.01)));
                                        } else {
                                            engineer.shiftWarning.setValue(0.0);
                                        }

                                        //Enums
                                        switch (engineer.drivetrainType.getValue()) {
                                            case 0:
                                                engineer.drivetrainTypeString.setValue("FWD");
                                                break;
                                            case 1:
                                                engineer.drivetrainTypeString.setValue("RWD");
                                                break;
                                            case 2:
                                                engineer.drivetrainTypeString.setValue("AWD");
                                                break;
                                        }
                                        switch (engineer.carClass.getValue()) {
                                            case 0:
                                                engineer.carClassString.setValue("E");
                                                break;
                                            case 1:
                                                engineer.carClassString.setValue("D");
                                                break;
                                            case 2:
                                                engineer.carClassString.setValue("C");
                                                break;
                                            case 3:
                                                engineer.carClassString.setValue("B");
                                                break;
                                            case 4:
                                                engineer.carClassString.setValue("A");
                                                break;
                                            case 5:
                                                engineer.carClassString.setValue("S");
                                                break;
                                            case 6:
                                                engineer.carClassString.setValue("R");
                                                break;
                                            case 7:
                                                engineer.carClassString.setValue("P");
                                                break;
                                            case 8:
                                                engineer.carClassString.setValue("X");
                                                break;
                                        }
                                    }

                                } catch (Exception e) {
                                    //System.out.println(e.toString()                                );
                                    e.printStackTrace();
                                }
                            });
                            // Reset the length of the packet before reusing it.
                            packet.setLength(buffer.length);
                        }
                    System.out.println("closed socket listener");
                } catch (Exception e) {
                    System.err.println(e);
                    System.exit(1);
                }
            }

        }.start();

    }

    private ByteBuffer getBytes(byte[] buffer, int offset, int length) {
        return ByteBuffer.wrap(Arrays.copyOfRange(buffer, offset, length)).order(ByteOrder.LITTLE_ENDIAN);
    }

    private double getVector(Double x, Double y, Double z) {
        double resultVector = 0.0;
        double tmpX = Math.pow(x, 2);
        double tmpY = Math.pow(y, 2);
        double tmpZ = Math.pow(z, 2);
        resultVector = Math.sqrt(tmpX + tmpY + tmpZ);
        return resultVector;
    }

}
