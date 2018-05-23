package org.example.components;

import org.example.beans.Simpledocument;
import org.hippoecm.hst.component.support.bean.BaseHstComponent;
import org.hippoecm.hst.core.component.HstComponentException;
import org.hippoecm.hst.core.component.HstRequest;
import org.hippoecm.hst.core.component.HstResponse;
import org.hippoecm.hst.core.request.HstRequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SimpleComponent extends BaseHstComponent {

    public static final Logger log = LoggerFactory.getLogger(SimpleComponent.class);

    //This method is called just before the view is rendered, and its purpose is to perform any business logic and prepare any data that is required to render the view.
    @Override
    public void doBeforeRender(final HstRequest request, final HstResponse response) throws HstComponentException {
        super.doBeforeRender(request, response);
        final HstRequestContext ctx = request.getRequestContext();

        // Retrieve the document based on the URL
        Simpledocument document = (Simpledocument) ctx.getContentBean();

        if (document != null) {
            // Put the document on the request
            request.setAttribute("document", document);
        }
    }
}