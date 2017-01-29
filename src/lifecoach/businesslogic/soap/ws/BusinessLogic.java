package lifecoach.businesslogic.soap.ws;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.WebResult;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;

import lifecoach.localdb.soap.ws.Measure;

@WebService
@SOAPBinding(style = Style.DOCUMENT, use=Use.LITERAL, parameterStyle= ParameterStyle.WRAPPED) //optional
public interface BusinessLogic {

    @WebMethod(operationName="savePersonMeasure")
    @WebResult(name="person") 
    public Feedback savePersonMeasure(@WebParam(name="personId") long id, @WebParam(name="measure") Measure newMeasure);

}
