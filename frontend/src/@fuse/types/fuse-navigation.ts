export interface FuseNavigationItem
{
    id: string;
    subject: string;
    type: 'item' | 'group' | 'collapsable';
    translate?: string;
    icon?: string;
    hidden?: boolean;
    url?: string;
    classes?: string;
    exactMatch?: boolean;
    externalUrl?: boolean;
    openInNewTab?: boolean;
    function?: any;
    badge?: {
        subject?: string;
        translate?: string;
        bg?: string;
        fg?: string;
    };
    children?: FuseNavigationItem[];
}

export interface FuseNavigation extends FuseNavigationItem
{
    children?: FuseNavigationItem[];
}
