package press.turngeek.mycampaign.services;

import press.turngeek.mycampaign.model.Campaign;

import javax.enterprise.context.RequestScoped;
import java.util.LinkedList;
import java.util.List;

@RequestScoped
public class CampaignServiceBean implements CampaignService {

  @Override
  public List<Campaign> getAllCampaigns() {
     return new LinkedList<Campaign>();
  }

}