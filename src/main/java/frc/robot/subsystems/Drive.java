package frc.robot.subsystems;

import java.util.DoubleSummaryStatistics;
import java.util.function.DoubleSupplier;

import com.chopshop166.chopshoplib.logging.LoggedSubsystem;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.maps.subsystems.DriveMap;
import frc.robot.maps.subsystems.DriveMap.Data;

public class Drive extends LoggedSubsystem<Data, DriveMap> {
    private DifferentialDrive diffDrive;
    private DoubleSupplier fwdDrive;
    private DoubleSupplier rtDrive;

    public Drive(DriveMap map, DoubleSupplier forward, DoubleSupplier rotation) {
        super(new Data(), map);
        fwdDrive = forward;
        rtDrive = rotation;
        diffDrive = new DifferentialDrive((double speed) -> {
            getData().leftMotor.setpoint = speed;
        }, (double speed) -> {
            getData().rightMotor.setpoint = speed;
        });
    }

    public Command arcadeDrive() {
        return run(() -> {
            diffDrive.arcadeDrive(fwdDrive.getAsDouble(), rtDrive.getAsDouble());
        });
    }

    @Override
    public void safeState() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'safeState'");
    }

}
