import * as process from "process";

export const environment = {
    production: true,
    hmr       : false,
    api:{
        url: process.env.PROXY_API || 'http://localhost:8080'
    }
};
