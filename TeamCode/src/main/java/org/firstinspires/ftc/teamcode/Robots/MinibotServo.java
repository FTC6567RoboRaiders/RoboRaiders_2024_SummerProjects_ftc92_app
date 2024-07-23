package org.firstinspires.ftc.teamcode.Robots;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class MinibotServo {

    public DcMotorEx lMotor = null;
    public DcMotorEx rMotor = null;

    public Servo intakeServo = null;

    public HardwareMap hwMap = null;

    public MinibotServo() { }

    public void initialize(HardwareMap ahwMap) {
        hwMap = ahwMap;

        lMotor = hwMap.get(DcMotorEx.class, "lMotor");
        rMotor = hwMap.get(DcMotorEx.class, "rMotor");

        intakeServo = hwMap.get(Servo.class, "intakeServo");

        // pre-set servo position

        lMotor.setDirection(DcMotor.Direction.REVERSE);
        rMotor.setDirection(DcMotor.Direction.FORWARD);

        lMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        lMotor.setPower(0.0);
        rMotor.setPower(0.0);

        resetEncoders();

        lMotor.setMode(DcMotorEx.RunMode.RUN_WITHOUT_ENCODER);
        rMotor.setMode(DcMotorEx.RunMode.RUN_WITHOUT_ENCODER);
    }
        //**********************************************************************************************
        //
        // DRIVE TRAIN METHODS
        //
        //**********************************************************************************************

        public void setDriveMotorPower(double leftPower, double rightPower) {
            lMotor.setPower(leftPower);
            rMotor.setPower(rightPower);
        }

        public void resetEncoders() {
            lMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            rMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        }

        //**********************************************************************************************
        //
        // END DRIVE TRAIN METHODS
        //
        //**********************************************************************************************

        //**********************************************************************************************
        //
        // GUNNER METHODS
        //
        //**********************************************************************************************

        public void setIntakePosition(double position) { intakeServo.setPosition(position); }

        //**********************************************************************************************
        //
        // END GUNNER METHODS
        //
        //**********************************************************************************************
}
