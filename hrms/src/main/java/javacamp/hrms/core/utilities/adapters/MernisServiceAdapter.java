package javacamp.hrms.core.utilities.adapters;

import java.rmi.RemoteException;

import org.springframework.stereotype.Service;

import javacamp.hrms.core.utilities.abstracts.MernisValidationService;
import javacamp.hrms.entities.concretes.Candidate;

import tr.gov.nvi.tckimlik.WS.KPSPublicSoap;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;

@Service
public class MernisServiceAdapter implements MernisValidationService{

	@Override
	public boolean validate(Candidate candidate) {
		 boolean result = true;
		 KPSPublicSoap soapClient = new KPSPublicSoapProxy();
		  try {
			  result = soapClient.TCKimlikNoDogrula(Long.parseLong(candidate.getNationalIdentity()), candidate.getFirstName(), candidate.getLastName(), candidate.getDateOfBirth().getYear());
		  } catch (NumberFormatException e) {
			   e.printStackTrace();
		  } catch (RemoteException e) {
		       e.printStackTrace();
		  }
		
		return result;
	}

}
