package press.turngeek.mycampaign.data;

import press.turngeek.mycampaign.model.Account;
import press.turngeek.mycampaign.model.Campaign;
import press.turngeek.mycampaign.model.Donation;
import press.turngeek.mycampaign.model.Donation.Status;
import press.turngeek.mycampaign.util.Events.Added;
import press.turngeek.mycampaign.util.Events.Deleted;
import press.turngeek.mycampaign.services.CampaignService;
import javax.enterprise.context.SessionScoped;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.inject.Inject;
import javax.enterprise.inject.Produces;
import javax.enterprise.event.Observes;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

@SessionScoped
public class CampaignListProducer implements Serializable {
    private static final long serialVersionUID = -182866064791747156L;
    private List<Campaign>    campaigns;
    @Inject
    private CampaignService   campaignService;

    @PostConstruct
    public void init() {
        campaigns = campaignService.getAllCampaigns();
    }

    @Produces
    @Named
    public List<Campaign> getCampaigns() {
        return campaigns;
    }

    public void onCampaignAdded(@Observes @Added Campaign campaign) {
        getCampaigns().add(campaign);
    }

    public void onCampaignDeleted(@Observes @Deleted Campaign campaign) {
        getCampaigns().remove(campaign);
    }

}
