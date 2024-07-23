package org.firstinspires.ftc.teamcode.TeleOp;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Robots.MinibotServo;

@TeleOp(name = "Claw Teleop")

public class ClawTeleop extends OpMode {
    public MinibotServo robot = new MinibotServo();

    @Override
    public void init() {
        robot.initialize(hardwareMap);

        robot.setIntakePosition(0.0);
    }

    @Override
    public void start() {  }

    @Override
    public void loop() {
        doDrive();
        doIntake();
    }

    public void doDrive() {
        double lPower = gamepad1.left_stick_y;
        double rPower = gamepad1.right_stick_y;

        robot.setDriveMotorPower(lPower, rPower);
    }

    public void doIntake() {
        if(gamepad1.dpad_down) { robot.setIntakePosition(0.0); }
        if(gamepad1.dpad_right) { robot.setIntakePosition(0.5); }
        if(gamepad1.dpad_up) { robot.setIntakePosition(1.0); }
    }
}
