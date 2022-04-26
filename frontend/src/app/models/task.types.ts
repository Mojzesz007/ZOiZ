import { Entity } from "./entity.type";

export interface Task extends Entity {
    dateFrom: Date;
    dateTo: Date;
    subject: string;
    message: string;
    done: boolean;
    parentToken?: any;
    user?: any;
    sendNotification: boolean;
    entityDescription: string;
}