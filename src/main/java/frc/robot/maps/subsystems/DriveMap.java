package frc.robot.maps.subsystems;

import com.chopshop166.chopshoplib.logging.DataWrapper;
import com.chopshop166.chopshoplib.logging.LoggableMap;
import com.chopshop166.chopshoplib.logging.data.MotorControllerData;
import com.chopshop166.chopshoplib.motors.SmartMotorController;

public class DriveMap implements LoggableMap<DriveMap.Data> {

    SmartMotorController leftMotor;
    SmartMotorController rightMotor;

    public DriveMap(SmartMotorController leftMotor, SmartMotorController rightMotor) {
        this.leftMotor = leftMotor;
        this.rightMotor = rightMotor;
    }

    public DriveMap() {
        this.leftMotor = new SmartMotorController();
        this.rightMotor = new SmartMotorController();
    }

    @Override
    public void updateData(Data data) {
        data.leftMotor.updateData(this.leftMotor);
        data.rightMotor.updateData(this.rightMotor);
    }

    public static class Data extends DataWrapper {
        public MotorControllerData leftMotor = new MotorControllerData();
        public MotorControllerData rightMotor = new MotorControllerData();
    }

}
