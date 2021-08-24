/*
 * Copyright (c) 2021 tecc
 * Lahc is licensed under the MIT licence.
 */

package me.tecc.lahc.tests;

import lombok.extern.slf4j.Slf4j;
import me.tecc.lahc.HttpClient;
import me.tecc.lahc.http.HttpRequest;
import me.tecc.lahc.http.HttpResponse;
import me.tecc.lahc.util.Promise;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

@Slf4j
public class GeneralTest {
    HttpClient client = new HttpClient();

    @Test
    void text() {
        HttpRequest request = new HttpRequest()
                .url("https://example.com/index.html");

        Promise<HttpResponse> future = client.execute(request);
        Assertions.assertDoesNotThrow(() -> {
            future.then(response -> {
                Assertions.assertTrue(response.isSuccessful(), "Response is not successful: " + response.getStatus());
            }).exception(value -> {
                throw new AssertionError();
            }).run();
        });
    }
}
