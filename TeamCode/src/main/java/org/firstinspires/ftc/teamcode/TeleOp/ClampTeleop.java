package org.firstinspires.ftc.teamcode.TeleOp;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Robots.MinibotServo;


/**
 * ClampBot Telelop
 */
@TeleOp(name = "Clamp Teleop")

public class ClampTeleop extends OpMode {
    public MinibotServo robot = new MinibotServo();

    @Override
    public void init() {
        robot.initialize(hardwareMap);

        robot.setIntakePosition(1.0);
    }

    @Override
    public void start() {  }

    @Override
    public void loop() {
        doDrive();
        doIntake();
    }

    public void doDriveDirect() { robot.setDriveMotorPower(gamepad1.left_stick_y, gamepad1.right_stick_y); }

    public void doDrive() {
        double leftPower = gamepad1.left_stick_y - gamepad1.right_stick_x;
        double rightPower = gamepad1.left_stick_y + gamepad1.right_stick_x;

        double max = Math.max(Math.abs(leftPower), Math.abs(rightPower));
        if (max > 1.0) {
            leftPower /= max;
            rightPower /= max;
        }

        robot.setDriveMotorPower(leftPower, rightPower);
    }

    public void doIntake() {
        if(gamepad1.left_bumper) { robot.setIntakePosition(0.0); }
        if(gamepad1.right_bumper) { robot.setIntakePosition(1.0); }
    }
}
