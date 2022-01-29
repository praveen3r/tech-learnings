import React from 'react';
import { useNavigate } from 'react-router-dom';

export const OrderSummary = () => {
    const navigate = useNavigate();

    return (
        <>
            <div>Order confirmed</div>
            <button onClick={() => navigate('')}>Go back</button>
        </>
    );
};
