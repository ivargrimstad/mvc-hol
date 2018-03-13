/*
 * The MIT License
 *
 * Copyright 2015 Ivar Grimstad (ivar.grimstad@gmail.com).
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
package eu.agilejava.mvc.part3;

import eu.agilejava.mvc.BirthDayService;
import eu.agilejava.mvc.Messages;
import java.util.ResourceBundle;
import java.util.UUID;
import static java.util.stream.Collectors.toList;
import javax.inject.Inject;
import javax.mvc.MvcContext;
import javax.mvc.annotation.Controller;
import javax.mvc.annotation.CsrfValid;
import javax.mvc.annotation.View;
import javax.mvc.binding.BindingResult;
import javax.validation.Valid;
import javax.ws.rs.BeanParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import static javax.ws.rs.core.Response.Status.BAD_REQUEST;

/**
 *
 * @author Ivar Grimstad (ivar.grimstad@gmail.com)
 */
@Controller
@Path("part-3/greeting")
public class PartThreeGreetingController {

    @Inject
    private Greeting greeting;

    @Inject
    private Messages messages;

    @Inject
    private BindingResult br;
    
    @Inject
    private MvcContext ctx;

    @Inject
    private BirthDayService birthdayService;
    
    @GET
    @View("part_3_greetings_form.jsp")
    @Path("new")
    public void view() {
    }

    @CsrfValid
    @POST
    @Path("new")
    public Response hello(@Valid @BeanParam HelloForm helloForm) {

        if (br.isFailed()) {
            messages.setErrors(br.getAllValidationErrors().stream().collect(toList()));
            return Response.status(BAD_REQUEST).entity( "part_3_greetings_form.jsp").build();
        }

        greeting.setFirstName(helloForm.getFirstName());
        greeting.setLastName(helloForm.getLastName());
        greeting.setCountry(ctx.getLocale().getDisplayCountry());
        greeting.setDaysToBirthday(birthdayService.calculateDaysToBirthday(helloForm.getBirthDate()));
        greeting.setUuid(UUID.randomUUID().toString());

        ResourceBundle greetings = ResourceBundle.getBundle("greetings", ctx.getLocale());
        greeting.setText(greetings.getString("greeting"));
        
        return Response.ok("redirect:part-3/confirmation").build();
    }
}
