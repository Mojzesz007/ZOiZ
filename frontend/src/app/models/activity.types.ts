import { Entity } from "./entity.type";

export interface Activity extends Entity{
    activityStart: Date;
    activityEnd: Date;
    subject: string;
    body: string;
    important: boolean;
}