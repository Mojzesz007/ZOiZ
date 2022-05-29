
import * as process from "process";
export const environment = {
    production: false,
    hmr       : true,
    api:{
        url: process.env.PROXY_API || 'http://localhost:8080'
    }
};
