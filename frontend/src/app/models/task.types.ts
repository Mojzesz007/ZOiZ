export interface Task {
    id: number;
    version: number;
    createdAt: Date;
    updatedAt: Date;
    draft: boolean;
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