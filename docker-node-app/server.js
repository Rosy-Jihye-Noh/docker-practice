const express = require("express")

const PORT = 8081;

const app = express()

app.get("/", (req, res) => {
    res.send("안녕하세요.");
});

app.listen(PORT);
console.log("server in running...");