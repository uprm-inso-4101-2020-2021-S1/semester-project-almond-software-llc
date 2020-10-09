import React from 'react';
import Card from '@material-ui/core/Card';
import CardContent from '@material-ui/core/CardContent';
import Typography from '@material-ui/core/Typography';

export default function CourseCard() {

    return (
        <Card style={{ width: '150px', height: '50px' }}>
            <CardContent>
                <Typography>CURSO 4200</Typography>
            </CardContent>
        </Card>
    );
}
