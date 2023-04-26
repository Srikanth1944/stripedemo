package com.talenteddeveloper.stripepayment.web.controller;

import com.stripe.Stripe;
import com.talenteddeveloper.stripepayment.dto.CreatePayment;
import com.talenteddeveloper.stripepayment.dto.CreatePaymentResponse;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import com.stripe.param.PaymentIntentCreateParams;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {

    @PostMapping("/create-payment-intent")
    public CreatePaymentResponse createPaymentIntent(@RequestBody CreatePayment createpayment) throws StripeException {
        Stripe.apiKey = "sk_test_51KMe74BKl4Mnc2eo3wIxttx5gBRfuVmzJlPUpdV4yvgzc13JTsPZZRiU7nz0j2aLYE0q72CrvAGQko8SjrEjnDVw00443v6t85";

        PaymentIntentCreateParams params =
                PaymentIntentCreateParams.builder()
                        .setAmount(345L) //price according to product
                        .setCurrency("eur")
                        .build();

        // Create a PaymentIntent with the order amount and currency
        PaymentIntent paymentIntent = PaymentIntent.create(params);

        return new CreatePaymentResponse(paymentIntent.getClientSecret());

    }
}
