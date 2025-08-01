const express = require("express");
const redis = require('redis');

const client = redis.createClient({
    url: 'redis://redis-server:6379'
});

async function start() {
    await client.connect();
    console.log('Redis connected...');

    const app = express();
    app.get("/", async (req, res) => {
        let number = await client.get('number') || 0;
        res.send(`숫자가 1씩 올라갑니다. 숫자: ${number}`);
        await client.set('number', Number(number) + 1);
    });

    app.listen(8082, '0.0.0.0', () => {
        console.log("server running on 8082");
    });
}


start().catch(console.log);