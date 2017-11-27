/*
 * The MIT License
 *
 * Copyright 2017 Ivar Grimstad (ivar.grimstad@gmail.com).
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package eu.agilejava.mvc;

import java.time.LocalDate;
import static java.time.LocalDate.parse;
import java.time.format.DateTimeFormatter;
import static java.time.temporal.ChronoUnit.DAYS;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Ivar Grimstad (ivar.grimstad@gmail.com)
 */
@RequestScoped
public class BirthDayService {

    public int calculateDaysToBirthday(final String birthDate) {

        final LocalDate now = LocalDate.now();
        final LocalDate bdThisYear = parse(birthDate, DateTimeFormatter.ISO_DATE).withYear(now.getYear());        
        
        if (bdThisYear.isAfter(now)) {
            return (int) now.until(bdThisYear, DAYS);
        } else {
            return (int) now.until(bdThisYear.plusYears(1), DAYS);
        }
    }
}
