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
package eu.agilejava.mvc.part3;

import java.util.logging.Logger;
import static java.util.logging.Logger.getLogger;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.mvc.event.AfterControllerEvent;
import javax.mvc.event.AfterProcessViewEvent;
import javax.mvc.event.BeforeControllerEvent;
import javax.mvc.event.BeforeProcessViewEvent;
import javax.mvc.event.ControllerRedirectEvent;

/**
 *
 * @author Ivar Grimstad (ivar.grimstad@gmail.com)
 */
@ApplicationScoped
public class EventObserver {
    
    private static final Logger LOG = getLogger(EventObserver.class.getName());
    
    private void beforeController(@Observes BeforeControllerEvent bfe) {
        LOG.info(() -> "Before Controller, path= " + bfe.getUriInfo().getPath());
    }
    
    private void afterontroller(@Observes AfterControllerEvent afe) {
        LOG.info(() -> "After Controller, path= " + afe.getUriInfo().getPath());
    }

    private void beforeView(@Observes BeforeProcessViewEvent bve) {
        LOG.info(() -> "Before view, view= " + bve.getView());
    }

    private void afterView(@Observes AfterProcessViewEvent ave) {
        LOG.info(() -> "After view, view= " + ave.getView());
    }
 
     private void redirect(@Observes ControllerRedirectEvent cre ) {
        LOG.info(() -> "Redirect, location= " + cre.getLocation().toString());
    }
}
