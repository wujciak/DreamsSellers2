export interface Statistic {
  highestPrice: number;
  averagePrice: number;
  totalItems: number;
  mostPopularEndpoint: string;
  lastCalledEndpoint: string;
  totalRequests: number;
  endpointCallCounts: { [key: string]: number };
}
