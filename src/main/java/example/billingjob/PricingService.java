package example.billingjob;

import org.springframework.beans.factory.annotation.Value;

import java.util.Random;
import java.util.logging.Logger;

public class PricingService {

    private final Logger logger = Logger.getLogger(PricingService.class.getName());

    @Value("${spring.cellular.pricing.data:0.01}")
    private float dataPricing;

    @Value("${spring.cellular.pricing.call:0.5}")
    private float callPricing;

    @Value("${spring.cellular.pricing.sms:0.1}")
    private float smsPricing;

    private final Random random = new Random();

    public float getDataPricing() {
        if (this.random.nextInt(1000) % 7 == 0) {

            // check the output and see how things work behind the scenes.
//            logger.info("Error while retrieving data pricing");
            throw new PricingException("Error while retrieving data pricing");
        }
        return this.dataPricing;
    }

    public float getCallPricing() {
        return this.callPricing;
    }

    public float getSmsPricing() {
        return this.smsPricing;
    }
}