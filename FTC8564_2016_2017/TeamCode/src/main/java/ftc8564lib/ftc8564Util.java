/*
 * Copyright (c) 2015 Titan Robotics Club (http://www.titanrobotics.com)
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package ftc8564lib;

/**
 * This class contains platform independent utility methods.
 * All methods in this class are static. It is not necessary
 * to instantiate this class to call its methods.
 */
public class ftc8564Util
{
    /**
     * This method clips the given value to the range limited
     * by the given low and high limits.
     *
     * @param value specifies the value to be clipped
     * @param lowLimit specifies the low limit of the range.
     * @param highLimit specifies the high limit of the range.
     * @return the result of the clipped value.
     */
    public static int limit(int value, int lowLimit, int highLimit)
    {
        return (value < lowLimit)?
                lowLimit:
                (value > highLimit)?
                        highLimit:
                        value;
    }   //limit

    /**
     * This method clips the given value to the range limited
     * by the given low and high limits.
     *
     * @param value specifies the value to be clipped
     * @param lowLimit specifies the low limit of the range.
     * @param highLimit specifies the high limit of the range.
     * @return the result of the clipped value.
     */
    public static double limit(double value, double lowLimit, double highLimit)
    {
        return (value < lowLimit)?
                lowLimit:
                (value > highLimit)?
                        highLimit:
                        value;
    }   //limit

    /**
     * This method clips the given value to the range between -1.0 and 1.0.
     *
     * @param value specifies the value to be clipped
     * @return the result of the clipped value.
     */
    public static double limit(double value)
    {
        return limit(value, -1.0, 1.0);
    }   //limit

    /**
     * This method scales the given value from the source range to the target range.
     *
     * @param value specifies the value to be scaled.
     * @param lowSrcRange specifies the low limit of the source range.
     * @param highSrcRange specifies the high limit of the source range.
     * @param lowDstRange specifies the low limit of the target range.
     * @param highDstRange specifies the high limit of the target range
     * @return the result of the scaled value.
     */
    public static int scaleRange(
            int value,
            int lowSrcRange, int highSrcRange,
            int lowDstRange, int highDstRange)
    {
        return lowDstRange +
                (value - lowSrcRange)*(highDstRange - lowDstRange)/
                        (highSrcRange - lowSrcRange);
    }   //scaleRange

    /**
     * This method scales the given value from the source range to the target range.
     *
     * @param value specifies the value to be scaled.
     * @param lowSrcRange specifies the low limit of the source range.
     * @param highSrcRange specifies the high limit of the source range.
     * @param lowDstRange specifies the low limit of the target range.
     * @param highDstRange specifies the high limit of the target range
     * @return the result of the scaled value.
     */
    public static double scaleRange(
            double value,
            double lowSrcRange, double highSrcRange,
            double lowDstRange, double highDstRange)
    {
        return lowDstRange +
                (value - lowSrcRange)*(highDstRange - lowDstRange)/
                        (highSrcRange - lowSrcRange);
    }   //scaleRange

    /**
     * This method checks if the given value is within the deadband range.
     * If so, it returns 0.0 else it returns the unchanged value.
     *
     * @param value specifies the value to be chacked.
     * @param deadband specifies the deadband zone.
     * @return the value 0.0 if within deadband, unaltered otherwise.
     */
    public static double applyDeadband(double value, double deadband)
    {
        return Math.abs(value) >= deadband? value: 0.0;
    }   //applyDeadband

    /**
     * This method combines two bytes into an integer.
     *
     * @param low specifies the low byte.
     * @param high specifies the high byte.
     *
     * @return the converted interger.
     */
    public static int bytesToInt(byte low, byte high)
    {
        return ((int)low & 0xff) | (((int)high & 0xff) << 8);
    }   //bytesToInt

    /**
     * This method converts a byte into an integer.
     *
     * @param data specifies the byte data.
     *
     * @return the convertyed interger.
     */
    public static int bytesToInt(byte data)
    {
        return bytesToInt(data, (byte)0);
    }   //bytesToInt

    /**
     * This method combines two bytes into a short.
     *
     * @param low specifies the low byte.
     * @param high specifies the high byte.
     *
     * @return the converted short.
     */
    public static short bytesToShort(byte low, byte high)
    {
        return (short)bytesToInt(low, high);
    }   //bytesToShort

}   //class TrcUtil