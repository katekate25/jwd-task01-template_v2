package by.tc.task01.dao.impl.handler;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import by.tc.task01.entity.Appliance;


/**
 * FindAppliancesSaxHandler
 */
public abstract class AbstractAppliancesSaxHandler extends DefaultHandler
{

   private List<Appliance> appliances;

   protected void addAppliance(Appliance appliance)
   {
      appliances.add(appliance);
   }

   /**
    * Get appliances
    *
    * @return appliances
    */
   public List<Appliance> getAppliances()
   {
      return appliances;
   }

   /**
    * {@inheritdoc}
    */
   @Override
   public void startDocument(){
      appliances = new ArrayList<>();
   }

}
