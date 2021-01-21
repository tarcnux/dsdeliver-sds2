import React, { useEffect, useState } from 'react';
import { ScrollView, StyleSheet, Alert, Text } from 'react-native';
import { TouchableWithoutFeedback } from 'react-native-gesture-handler';
import { fetchOrders } from '../api';
import Header from '../Header';
import OrderCard from '../OrderCard';
import { Order } from '../types';


export default function Orders() {

  const [orders, setOrders] = useState<Order[]>([]);
  const [isLoading, setIsLoading] = useState(false);

  useEffect(() => {
    setIsLoading(true);
    fetchOrders()
      .then(response => setOrders(response.data))
      .catch(() => Alert.alert('Erro ao buscar os pedidos.'))
      .finally(() => setIsLoading(false));
  }, []);

  return (
    <>
    <Header />
    <ScrollView style={styles.container}>
        {isLoading ? (
          <Text>Carregando pedidos...</Text>
        ) : (
          orders.map(order => (
            <TouchableWithoutFeedback key={order.id}>
              <OrderCard order={order} />
            </TouchableWithoutFeedback>
          ))
        )}
    </ScrollView>
    </>
  );
}

const styles = StyleSheet.create({
    container: {
      paddingLeft: '5%',
      paddingRight: '5%',
    }
  });
